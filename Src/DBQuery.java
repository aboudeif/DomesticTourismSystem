import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DBQuery {
    public static int getCityID(String city) throws Exception{
        int id = -1;
        String querey = "SELECT [id] FROM [City] WHERE [city] = '"+ city +"';";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(querey);
        if(res.next())
            id = res.getInt("id");
        return id;
    }

    public static String getCityName(int cityID) throws Exception{
        String city = "";
        String querey = "SELECT [city] FROM [City] WHERE [id] = "+ cityID +";";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(querey);
        if(res.next())
            city = res.getString("city");
        return city;
    }
    
    public static List<String> getCityData() throws Exception{
        List<String> cityList = new ArrayList<>();
        String querey = "SELECT DISTINCT [city] FROM [City];";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(querey);
        while(res.next())
            cityList.add(res.getString("city"));

        return cityList;
    }

    public static int getSPID(String partner) throws Exception{
        int id = -1;
        
        String querey = "SELECT [id] FROM [ServiceProvider] WHERE [name] = '"+ partner +"';";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(querey);
        if(res.next())
            id = res.getInt("id");
        
        return id;
    }

    public static String getSPName(int partnerID) throws Exception{
        String name = null;

        String querey = "SELECT [name] FROM [ServiceProvider] WHERE [id] = "+ partnerID +";";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(querey);
        if(res.next())
            name = res.getString("name");
        
            return name;
    }

    public static List<String> getSPList(String cls) throws Exception{
        List<String> list = new ArrayList<>();
        
        String sqlString = "SELECT DISTINCT [name] FROM [ServiceProvider] WHERE [class] = '"+cls+"';";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(sqlString);
        while(res.next())
            list.add(res.getString("name"));
            
        return list;
    }
    
    public static ResultSet getSelectiveData(String tableName, String columnName, int value) throws Exception{
        String sqlString = "SELECT * FROM ["+tableName+"] WHERE ["+columnName+"] = "+value+";";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(sqlString);
        return res;
    }
    
    public static ResultSet getSelectiveData(String tableName, String columnName, String value) throws Exception{
        String sqlString = "SELECT * FROM ["+tableName+"] WHERE ["+columnName+"] = '"+value+"';";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(sqlString);
        return res;
    }
    
    public static List<Partner> getResPartner(ResultSet res) throws Exception{
        List<Partner> list = new ArrayList<>();
        
        while(res.next()){
            Partner partner = new Partner();
            partner.setCls(res.getString("class"));
            partner.setId(res.getInt("id"));
            partner.setName(res.getString("name"));
            partner.setCrn(res.getString("crn"));
            partner.setEmail(res.getString("email"));
            partner.setCity(getCityName(res.getInt("cityID")));
            partner.setLocalAddress(res.getString("localAdd"));
            partner.setType(res.getString("type"));
            partner.setCreateDate(res.getDate("CREATEDate"));
            partner.setIdle(res.getBoolean("idle"));
            partner.setDiscount(res.getDouble("discount"));
            partner.setTourist(getResTourist(getSelectiveData("Tourist","prtID",res.getInt("id"))));
            list.add(partner);
        }
        return list;
    }
    
    public static Partner getPartner(int partID) throws Exception{
        Partner partner = new Partner();
        
        String sqlString = "SELECT * FROM [ServiceProvider] WHERE [class] = 'prt' AND [id] ="+partID+";";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(sqlString);
        if(res.next()){ 
            partner.setId(res.getInt("id"));
            partner.setName(res.getString("name"));
            partner.setCrn(res.getString("crn"));
            partner.setEmail(res.getString("email"));
            partner.setCity(getCityName(res.getInt("cityID")));
            partner.setLocalAddress(res.getString("localAdd"));
            partner.setType(res.getString("type"));
            partner.setCreateDate(res.getDate("CREATEDate"));
            partner.setIdle(res.getBoolean("idle"));
            partner.setDiscount(res.getDouble("discount"));
            partner.setTourist(getResTourist(getSelectiveData("Tourist","prtID",res.getInt("id"))));
        }
        
        return partner;
    }
     
    public static List<Campaign> getResCampaign(ResultSet res) throws Exception{
        List<Campaign> list = new ArrayList<>();
        
        while(res.next()){
            Campaign campaign = new Campaign();
            campaign.setId(res.getInt("id"));
            campaign.setTravel(res.getInt("trvID"));
            campaign.setAdvertisement(res.getInt("adID"));
            campaign.setMedia(res.getString("media"));
            campaign.setTargetedNum(res.getInt("targetedNum"));
            campaign.setReachedNum(res.getInt("reachedNum"));
            campaign.setStartDate(res.getDate("startDate"));
            campaign.setEndDate(res.getDate("endDate"));
            campaign.setRegDate(res.getDate("regDate"));
            campaign.setCost(res.getDouble("cost"));
            campaign.setIdle(res.getBoolean("idle"));
            
            list.add(campaign);
        }
        return list;
    }
    
    public static List<RegTourist> getResRegTourist(ResultSet res) throws Exception{
        List<RegTourist> list = new ArrayList<>();
        
        while(res.next()){
            RegTourist regTourist = new RegTourist();
            regTourist.setTourist(getTourist(res.getInt("turID")));
            regTourist.setTravel(res.getInt("trvID"));
            regTourist.setRegDate(res.getDate("regDate"));
            regTourist.setActualProfit(res.getDouble("actualProfit"));
            
            list.add(regTourist);
        }
        return list;
    }
    
    public static List<RegGuide> getResRegGuide(ResultSet res) throws Exception{
        List<RegGuide> list = new ArrayList<>();
        
        while(res.next()){
            RegGuide regGuide = new RegGuide();
            regGuide.setGuide(res.getInt("gudID"));
            regGuide.setTravel(res.getInt("trvID"));
            regGuide.setDaysNum(res.getInt("daysNum"));
            regGuide.setRegDate(res.getDate("regDate"));
            regGuide.setTotalCost(res.getDouble("totalCost"));
            
            list.add(regGuide);
        }
        return list;
    }
    
    public static List<RegHostel> getResRegHostel(ResultSet res) throws Exception{
        List<RegHostel> list = new ArrayList<>();
        
        while(res.next()){
            RegHostel regHostel = new RegHostel();
            regHostel.setHostel(res.getInt("hstID"));
            regHostel.setTravel(res.getInt("trvID"));
            regHostel.setRoomNum(res.getInt("roomNum"));
            regHostel.setNightsNum(res.getInt("nightsNum"));
            regHostel.setRegDate(res.getDate("regDate"));
            regHostel.setTotalCost(res.getDouble("totalCost"));
            
            list.add(regHostel);
        }
        return list;
    }
    
    public static List<RegPlace> getResRegPlace(ResultSet res) throws Exception{
        List<RegPlace> list = new ArrayList<>();
        
        while(res.next()){
            RegPlace regPlace = new RegPlace();
            regPlace.setPlace(getPlace(res.getInt("plcID")));
            regPlace.setTravel(res.getInt("trvID"));
            regPlace.setRegDate(res.getDate("regDate"));
            regPlace.setTotalCost(res.getDouble("totalCost"));
            
            list.add(regPlace);
        }
        return list;
    }
     
    public static List<RegTransport> getResRegTransport(ResultSet res) throws Exception{
        List<RegTransport> list = new ArrayList<>();
        
        while(res.next()){
            RegTransport regTransport = new RegTransport();
            regTransport.setTransport(getTransport(res.getInt("trsID")));
            regTransport.setTravel(res.getInt("trvID"));
            regTransport.setDaysNum(res.getInt("daysNum"));
            regTransport.setRegDate(res.getDate("regDate"));
            regTransport.setTotalCost(res.getDouble("totalCost"));
            
            list.add(regTransport);
        }
        return list;
    }
    
    public static ResultSet getRegistration(String table, int trvID) throws Exception{
        String sqlString = "SELECT * FROM "+table+" WHERE [trvID] = "+trvID+";";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(sqlString);
        return res;
    }
        
    public static Campaign getCampaign(int cmpID) throws Exception{
        Campaign campaign = new Campaign();
        
        String sqlString = "SELECT * FROM [Campaign] WHERE [id] = "+cmpID+";";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(sqlString);
        if(res.next()){
            campaign.setId(res.getInt("id"));
            campaign.setTravel(res.getInt("trvID"));
            campaign.setAdvertisement(res.getInt("adID"));
            campaign.setMedia(res.getString("media"));
            campaign.setTargetedNum(res.getInt("targetedNum"));
            campaign.setReachedNum(res.getInt("reachedNum"));
            campaign.setStartDate(res.getDate("startDate"));
            campaign.setEndDate(res.getDate("endDate"));
            campaign.setRegDate(res.getDate("regDate"));
            campaign.setCost(res.getDouble("cost"));
            campaign.setIdle(res.getBoolean("idle"));
        }
        return campaign;
    }
    
    public static List<Hostel> getResHostel(ResultSet res) throws Exception{
        List<Hostel> list = new ArrayList<>();
            
        while(res.next()){
            Hostel hostel = new Hostel();
            hostel.setId(res.getInt("id"));
            hostel.setName(res.getString("name"));
            hostel.setType(res.getString("type"));
            hostel.setHostelService(getSPName(res.getInt("ownerID")));
            hostel.setCreatDate(res.getDate("creatDate"));
            hostel.setIdle(res.getBoolean("idle"));
            hostel.setCity(getCityName(res.getInt("cityID")));
            hostel.setLocalAdd(res.getString("localAdd"));
            hostel.setCapacity(res.getInt("capacity"));
            hostel.setHotelDegree(res.getInt("hotelDegree"));
            hostel.setCost(res.getDouble("cost"));
            
            list.add(hostel);
        }
        return list;
    }
    
    public static Hostel getHostel(int ownerID) throws Exception{
        Hostel hostel = new Hostel();
        
        String sqlString = "SELECT * FROM [Hostel] WHERE [id] = "+ownerID+";";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(sqlString);
        if(res.next()){
            hostel.setId(res.getInt("id"));
            hostel.setName(res.getString("name"));
            hostel.setType(res.getString("type"));
            hostel.setHostelService(getSPName(res.getInt("ownerID")));
            hostel.setCreatDate(res.getDate("creatDate"));
            hostel.setIdle(res.getBoolean("idle"));
            hostel.setCity(getCityName(res.getInt("cityID")));
            hostel.setLocalAdd(res.getString("localAdd"));
            hostel.setCapacity(res.getInt("capacity"));
            hostel.setHotelDegree(res.getInt("hotelDegree"));
            hostel.setCost(res.getDouble("cost"));
        }
        return hostel;
    }
     
    public static List<Transport> getResTransport(ResultSet res) throws Exception{
        List<Transport> list = new ArrayList<>();

        while(res.next()){
            Transport transport = new Transport();
            transport.setId(res.getInt("id"));
            transport.setType(res.getString("type"));
            transport.setTransportService(getSPName(res.getInt("ownerID")));
            transport.setPanelNo(res.getString("panelNo"));
            transport.setModel(res.getString("model"));
            transport.setCreatDate(res.getDate("creatDate"));
            transport.setIdle(res.getBoolean("idle"));
            transport.setCity(getCityName(res.getInt("cityID")));
            transport.setCapacity(res.getInt("capacity"));
            transport.setCost(res.getDouble("cost"));

            list.add(transport);
        }
        return list;
    }
    
    public static Transport getTransport(int ownerID) throws Exception{
        Transport transport = new Transport();
        
        String sqlString = "SELECT * FROM [Transport] WHERE [id] = "+ownerID+";";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(sqlString);
        if(res.next()){
            transport.setId(res.getInt("id"));
            transport.setType(res.getString("type"));
            transport.setTransportService(getSPName(res.getInt("ownerID")));
            transport.setPanelNo(res.getString("panelNo"));
            transport.setModel(res.getString("model"));
            transport.setCreatDate(res.getDate("creatDate"));
            transport.setIdle(res.getBoolean("idle"));
            transport.setCity(getCityName(res.getInt("cityID")));
            transport.setCapacity(res.getInt("capacity"));
            transport.setCost(res.getDouble("cost"));
        }
        return transport;
    }
     
    public static List<Advertisement> getResAdvertisement(ResultSet res) throws Exception{
        List<Advertisement> list = new ArrayList<>();
        while(res.next()){
            Advertisement advertisement = new Advertisement();
            advertisement.setId(res.getInt("id"));
            advertisement.setAdService(getAdServiceName(res.getInt("companyID")));
            advertisement.setInfo(res.getString("info"));
            advertisement.setCreatDate(res.getDate("CREATEDate"));
            advertisement.setDesignCost(res.getDouble("designCost"));
            advertisement.setIdle(res.getBoolean("idle"));
            
            list.add(advertisement);
        }
        return list;
    }
    
    public static Advertisement getAdvertisement(int adID) throws Exception{
        Advertisement advertisement = new Advertisement();
        
        String sqlString = "SELECT * FROM [Advertisement] WHERE [id] = "+adID+";";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(sqlString);
        if(res.next()){
            advertisement.setId(res.getInt("id"));
            advertisement.setAdService(getAdServiceName(res.getInt("companyID")));
            advertisement.setInfo(res.getString("info"));
            advertisement.setCreatDate(res.getDate("CREATEDate"));
            advertisement.setDesignCost(res.getDouble("designCost"));
            advertisement.setIdle(res.getBoolean("idle"));
        }
        return advertisement;
    } 
     
    public static List<AdService> getResAdService(ResultSet res) throws Exception{
        List<AdService> list = new ArrayList<>();
        
        while(res.next()){
            AdService adService = new AdService();
            adService.setId(res.getInt("id"));
            adService.setName(res.getString("name"));
            adService.setCrn(res.getString("crn"));
            adService.setEmail(res.getString("email"));
            adService.setCity(getCityName(res.getInt("cityID")));
            adService.setLocalAddress(res.getString("localAdd"));
            adService.setType(res.getString("type"));
            adService.setCreateDate(res.getDate("CREATEDate"));
            adService.setIdle(res.getBoolean("idle"));
            adService.setAdvertisement(getResAdvertisement(getSelectiveData("Advertisement","companyID",res.getInt("id"))));
            list.add(adService);
        }
        return list;
    }
    
    public static String getAdServiceName(int companyID) throws Exception{
        String adService = null;
        
        String sqlString = "SELECT [name] FROM [ServiceProvider] WHERE [id] = "+companyID+";";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(sqlString);
        if(res.next())
            adService = res.getString("name");
            
        
        return adService;
    }
     
    public static List<HostelService> getResHostelService(ResultSet res) throws Exception{
        List<HostelService> list = new ArrayList<>();
        
        while(res.next()){
            HostelService hostelService = new HostelService();
            hostelService.setId(res.getInt("id"));
            hostelService.setName(res.getString("name"));
            hostelService.setCrn(res.getString("crn"));
            hostelService.setEmail(res.getString("email"));
            hostelService.setCity(getCityName(res.getInt("cityID")));
            hostelService.setLocalAddress(res.getString("localAdd"));
            hostelService.setType(res.getString("type"));
            hostelService.setCreateDate(res.getDate("CREATEDate"));
            hostelService.setIdle(res.getBoolean("idle"));
            hostelService.setHostel(getResHostel(getSelectiveData("Hostel","ownerID",res.getInt("id"))));
            list.add(hostelService);
        }
        return list;
    }
    
    public static HostelService getHostelService(int hstOwnerID) throws Exception{
        HostelService hostelService = new HostelService();
        
        String sqlString = "SELECT * FROM [ServiceProvider] WHERE [class] = 'hst' And [id] = "+hstOwnerID+";";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(sqlString);
        if(res.next()){
            hostelService.setId(res.getInt("id"));
            hostelService.setName(res.getString("name"));
            hostelService.setCrn(res.getString("crn"));
            hostelService.setEmail(res.getString("email"));
            hostelService.setCity(getCityName(res.getInt("cityID")));
            hostelService.setLocalAddress(res.getString("localAdd"));
            hostelService.setType(res.getString("type"));
            hostelService.setCreateDate(res.getDate("CREATEDate"));
            hostelService.setIdle(res.getBoolean("idle"));
            hostelService.setHostel(getResHostel(getSelectiveData("Hostel","ownerID",res.getInt("id"))));
        }
        
        return hostelService;
    }
     
    public static List<TransportService> getResTransportService(ResultSet res) throws Exception{
        List<TransportService> list = new ArrayList<>();
        
        while(res.next()){
            TransportService transportService = new TransportService();
            transportService.setCls(res.getString("class"));
            transportService.setId(res.getInt("id"));
            transportService.setName(res.getString("name"));
            transportService.setCrn(res.getString("crn"));
            transportService.setEmail(res.getString("email"));
            transportService.setCity(getCityName(res.getInt("cityID")));
            transportService.setLocalAddress(res.getString("localAdd"));
            transportService.setType(res.getString("type"));
            transportService.setCreateDate(res.getDate("CREATEDate"));
            transportService.setIdle(res.getBoolean("idle"));
            transportService.setTransport(getResTransport(getSelectiveData("Transport","ownerID",res.getInt("id"))));
            transportService.setPhones(getPhone(transportService.getId()));
            

            list.add(transportService);
        }
        return list;
    }
    
    public static TransportService getTransportService(int trsOwnerID) throws Exception{
        TransportService transportService = new TransportService();
        
        String sqlString = "SELECT * FROM [ServiceProvider] WHERE [class] = 'trs' And [id] = "+trsOwnerID+";";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(sqlString);
        if(res.next()){
            transportService.setId(res.getInt("id"));
            transportService.setName(res.getString("name"));
            transportService.setCrn(res.getString("crn"));
            transportService.setEmail(res.getString("email"));
            transportService.setCity(getCityName(res.getInt("cityID")));
            transportService.setLocalAddress(res.getString("localAdd"));
            transportService.setType(res.getString("type"));
            transportService.setCreateDate(res.getDate("CREATEDate"));
            transportService.setIdle(res.getBoolean("idle"));
            transportService.setTransport(getResTransport(getSelectiveData("Transport","ownerID",res.getInt("id"))));
        }
        return transportService;
    }
    
    public static List<String> getElementColumns(String tableName) throws Exception{
        List<String> list = new ArrayList<>();
        
        String sqlString = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME=N'"+tableName+"';";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(sqlString);
        while(res.next())
            list.add(res.getString("COLUMN_NAME"));

        return list;
    }
    
    public static Tourist getTourist(int id) throws Exception{ 
        String sqlString = "SELECT * FROM [Tourist] WHERE [id] = "+id+";";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(sqlString);

        Tourist t = new Tourist();
        if(res.next()){
            t.setId(res.getInt("id"));
            t.setPartner(getPartner(res.getInt("prtID")).getName());
            t.setInfo(res.getString("info"));
            t.setBalance(res.getDouble("balance"));
            t.setName(res.getString("Name"));
            t.setNid(res.getString("NID"));
            if(res.getBoolean("gender")) t.setGender("أنثي");
            else t.setGender("ذكر");
            t.setMobile(res.getString("mobile"));
            t.setBirthDate(res.getDate("birthDate"));
            t.setEmail(res.getString("email"));
            t.setCity(getCityName(res.getInt("cityID")));
            t.setLocalAddress(res.getString("localAdd"));
            t.setCreateDate(res.getDate("creatDate"));
            t.setIdle(res.getBoolean("idle"));
        }

        return t;
    }
    
    public static List<String> getSpecialtyData() throws Exception{
        List<String> list = new ArrayList<>();
        
        String sqlString = "SELECT DISTINCT [specialty] FROM [Guide];";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(sqlString);
        while(res.next())
            list.add(res.getString("specialty"));

        return list;
    }

    public static Map<Integer, String> getPartnerMap() throws Exception{
        Map<Integer, String> map = new TreeMap<>();
        
        String sqlString = "SELECT DISTINCT [id] [name] FROM [ServiceProvider] WHERE [class] = 'prt';";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(sqlString);
        while(res.next())
            map.put(res.getInt("id"), res.getString("name"));

        return map;
    }
  
    public static List<Schedule> getScheduleData() throws Exception{
        List<Schedule> scheduleList = new ArrayList<>();

        String querey = "DECLARE @date AS DATE = GETDATE(); SELECT startDate,id,title FROM Travel WHERE (YEAR(startDate) = YEAR(@date)) AND(MONTH(startDate) = MONTH(@date)) AND (DAY(@date)+4 >= DAY(startDate)) AND (DAY(startDate) >= DAY(@date)-2);";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(querey);
        
        while(res.next()){
            Schedule s = new Schedule();
            s.setStartDate(res.getDate("startDate"));
            s.setId(res.getInt("id"));
            s.setTitle(res.getString("title"));

            scheduleList.add(s);
        }

        return scheduleList;
    }
     
     //////////////////////////-----------------------------
    public static List<Integer> getTravelID() throws Exception{
        List<Integer> trvIdlList = new ArrayList<>();
        
        String querey = "SELECT [id] FROM [Travel];"; //WHERE [name] = '"+ partner +"';";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(querey);
        while(res.next())
            trvIdlList.add(res.getInt("id"));
        
        return trvIdlList;
    }
    
    public static List<TrvReport> getTrvReportData(List<Integer> trvIdlList) throws Exception{
        List<TrvReport> trvReportList = new ArrayList<>();
       
        for(Integer y: trvIdlList){
            String querey = "DECLARE  @id AS INT = "+Integer.toString(y)+" "+
            "SELECT (@id) AS id" +
            ",(SELECT title FROM Travel WHERE id = @id) AS title" +
            ",(SELECT creatDate FROM Travel WHERE id = @id) AS creatDate" +
            ",(SELECT idle FROM Travel WHERE id = @id) AS idle" +
            ",(SELECT startDate FROM Travel WHERE id = @id) AS startDate" +
            ",(SELECT endDate FROM Travel WHERE id = @id) AS endDate" +
            ",(SELECT DATEDIFF(DAY, (SELECT startDate FROM Travel WHERE id = @id) ,(SELECT endDate FROM Travel WHERE id = @id))) AS dayNum" +
            ",(SELECT price FROM Travel WHERE id = @id) AS price" +
            ",(SELECT COUNT(trvID) FROM RegTourist WHERE trvID = @id) AS turNum" +
            ",(SELECT COUNT(trvID) FROM RegTransport WHERE trvID = @id) AS trsNum" +
            ",(SELECT SUM(totalCost) FROM RegTransport WHERE trvID = @id) AS trsCost" +
            ",(SELECT COUNT(trvID) FROM RegHostel WHERE trvID = @id) AS hstNum" +
            ",(SELECT SUM(totalCost) FROM RegHostel WHERE trvID = @id) AS hstCost" +
            ",(SELECT COUNT(trvID) FROM RegGuide WHERE trvID = @id) AS gudNum" +
            ",(SELECT SUM(totalCost) FROM RegGuide WHERE trvID = @id) AS gudCost" +
            ",(SELECT COUNT(trvID) FROM RegPlace WHERE trvID = @id) AS plcNum" +
            ",(SELECT (SELECT SUM(totalCost) FROM RegPlace WHERE trvID = @id)*" +
            "(SELECT COUNT(trvID) FROM RegTourist WHERE trvID = @id)) AS plcCost" +
            ",(SELECT COUNT(trvID) FROM Campaign WHERE trvID = @id) AS adNum" +
            ",(SELECT SUM(cost) FROM Campaign WHERE trvID = @id) AS adCost" +
            ",(SELECT SUM(actualProfit) FROM RegTourist WHERE trvID = @id) AS trvProfit" +
            ",(SELECT (SELECT SUM(totalCost) FROM RegTransport WHERE trvID = @id) +" +
            "(SELECT SUM(totalCost) FROM RegHostel WHERE trvID = @id) +" +
            "((SELECT SUM(totalCost) FROM RegPlace WHERE trvID = @id)*" +
            "(SELECT COUNT(trvID) FROM RegTourist WHERE trvID = @id)) +" +
            "(SELECT SUM(totalCost) FROM RegGuide WHERE trvID = @id) +" +
            "(SELECT SUM(cost) FROM Campaign WHERE trvID = @id)) AS trvCost" +
            ",(SELECT (SELECT SUM(actualProfit) FROM RegTourist WHERE trvID = @id)-" +
            "((SELECT SUM(totalCost) FROM RegTransport WHERE trvID = @id)+" +
            "(SELECT SUM(totalCost) FROM RegHostel WHERE trvID = @id) +" +
            "((SELECT SUM(totalCost) FROM RegPlace WHERE trvID = @id)*" +
            "(SELECT COUNT(trvID) FROM RegTourist WHERE trvID = @id))+" +
            "(SELECT SUM(totalCost) FROM RegGuide WHERE trvID = @id) +" +
            "(SELECT SUM(cost) FROM Campaign WHERE trvID = @id))) AS trvNetProfit;";
                    
            ResultSet res = DBConnector.getConnection().createStatement().executeQuery(querey);
            
            while(res.next()){
                TrvReport a = new TrvReport();
                a.setId(res.getInt("id"));
                a.setTitle(res.getString("title"));
                a.setCreatDate(res.getDate("creatDate"));
                a.setIdle(res.getBoolean("idle"));
                a.setStartDate(res.getDate("startDate"));
                a.setEndDate(res.getDate("endDate"));
                a.setDayNum(res.getInt("dayNum"));
                a.setPrice(res.getDouble("price"));
                a.setTurNum(res.getInt("turNum"));
                a.setTrsNum(res.getInt("trsNum"));
                a.setTrsCost(res.getDouble("trsCost"));
                a.setHstCost(res.getInt("hstNum"));
                a.setHstCost(res.getDouble("hstCost"));
                a.setGudNum(res.getInt("gudNum"));
                a.setGudCost(res.getDouble("gudCost"));
                a.setPlcNum(res.getInt("plcNum"));
                a.setPlcCost(res.getDouble("plcCost"));
                a.setAdNum(res.getInt("adNum"));
                a.setAdCost(res.getDouble("adCost"));
                a.setTrvProfit(res.getDouble("trvProfit"));
                a.setTrvCost(res.getDouble("trvCost"));
                a.setTrvNetProfit(res.getDouble("trvNetProfit"));
            

                trvReportList.add(a);
            }
        }

        return trvReportList;
    }

     /////////////////////////------------------------------ 
     
    public static ResultSet getData(String table) throws Exception{
        String querey = "SELECT * FROM "+table+";";       
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(querey);
        return res;
    }
    
    public static ResultSet getSearch(String table,String searchColumn, String searchWord) throws Exception{
        String sqlString = "SELECT * FROM "+table+" WHERE "+searchColumn+" LIKE '%" + searchWord +"%';";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(sqlString);
        return res;
    }
     
    public static List<Agent> getResAgent(ResultSet res) throws SQLException, Exception{
        List<Agent> agentList = new ArrayList<>();
        while(res.next()){
            Agent a = new Agent();
            a.setId(res.getInt("id"));
            a.setName(res.getString("name"));
            a.setNid(res.getString("NID"));
            a.setIdle(res.getBoolean("idle"));
            a.setUsrID(res.getString("usrID"));
            a.setPassword(res.getString("password"));
            a.setMobile(res.getString("mobile"));
            a.setBirthDate(res.getDate("birthDate"));
            a.setLocalAddress(res.getString("localAdd"));
            a.setCity(getCityName(res.getInt("cityID")));
            a.setEmail(res.getString("email"));
            a.setCreateDate(res.getDate("creatDate"));
            if(res.getBoolean("gender")) a.setGender("أنثي");
            else a.setGender("ذكر");
            
            agentList.add(a);
        }
        return agentList;
    }

    public static void addAgent(String name, String nid, boolean gender, String mobile,
        Date birthDate, String email, String city, String localAddress, String usrID,
        String password , boolean idle) throws Exception{
        
        int genderBit = 0;
        if (gender) genderBit = 1;
        int idleBit = 0;
        if (idle) idleBit = 1;

        int cityID = -1;
        try {
            cityID = DBQuery.getCityID(city);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sqlString = "INSERT INTO [Agent]([name], [NID], gender, mobile, birthDate,"+
        "email, cityID, localAdd, usrID, password, idle)  values ('"+name+"','"+nid+"',"+genderBit+
        ",'"+mobile+"','"+birthDate.toString()+"','"+email+"',"+cityID+",'"+localAddress+"','"+usrID+
        "','"+password+"',"+idleBit+");";

        DBConnector.getConnection().createStatement().executeUpdate(sqlString);        
    }
    
    public static void addRegTourist(RegTourist regTourist) throws Exception{
       
        String sqlString = 
        " DECLARE @turprft AS MONEY = (SELECT price FROM Travel WHERE id = "+regTourist.getTravel()+" )-" +
        " ISNULL((SELECT discount FROM ServiceProvider WHERE id = (SELECT prtID FROM Tourist WHERE id = "+regTourist.getTourist().getId()+")),0)* " +
        " (SELECT price FROM Travel WHERE id = "+regTourist.getTravel()+" ) " +
        " IF (SELECT balance FROM Tourist WHERE id = "+regTourist.getTourist().getId()+") >= @turprft " +
        " BEGIN" +
        " INSERT INTO RegTourist (trvID,turID,actualProfit) VALUES ("+regTourist.getTravel()+","+regTourist.getTourist().getId()+",@turprft)" +
        " UPDATE Tourist SET balance = (balance-@turprft) WHERE id = "+regTourist.getTourist().getId()+
        " END; ";
         
        DBConnector.getConnection().createStatement().executeUpdate(sqlString);        
    }
       
    public static void deleteRegTourist(RegTourist regTourist) throws Exception{
        String sqlString = 
        "UPDATE Tourist SET balance = (balance+(SELECT actualProfit FROM RegTourist " +
        "WHERE trvID = "+regTourist.getTravel()+" AND turID = "+regTourist.getTourist().getId()+")) WHERE id = "+regTourist.getTourist().getId()+
        " DELETE RegTourist WHERE trvID = "+regTourist.getTravel()+" AND turID = "+regTourist.getTourist().getId() +";";
            
        DBConnector.getConnection().createStatement().executeUpdate(sqlString);        
    }
    
    public static void addRegPlace(RegPlace regPlace) throws Exception{
        String sqlString = 
        " INSERT INTO RegPlace (trvID,plcID,totalCost) VALUES ("+regPlace.getTravel()+","+
        regPlace.getPlaceId()+","+regPlace.getPlace().getCost()+"); ";
         
        DBConnector.getConnection().createStatement().executeUpdate(sqlString);        
    }
     
    public static void deleteRegPlace(RegPlace regPlace) throws Exception{
        String sqlString = " DELETE FROM RegPlace WHERE trvID = "+regPlace.getTravel()+
        " AND plcID = "+regPlace.getPlaceId()+" ;";
        DBConnector.getConnection().createStatement().executeUpdate(sqlString);        
    }
    
    public static void addRegTransport(RegTransport regTransport) throws Exception{
        String sqlString = "INSERT INTO RegTransport (trvID,trsID,daysNum,totalCost) VALUES ("+
        regTransport.getTravel()+","+regTransport.getTransportId()+","+regTransport.getDaysNum()+
        ","+regTransport.getDaysNum()+"*(SELECT cost FROM Transport WHERE id = "+regTransport.getTransport()+"));";
        
        DBConnector.getConnection().createStatement().executeUpdate(sqlString);        
    }
     
    public static void deleteRegTransport(RegTransport regTransport) throws Exception{
        String sqlString = " DELETE FROM RegTransport WHERE trvID = "+regTransport.getTravel()+
        " AND trsID = "+regTransport.getTransport()+" ;";
        
        DBConnector.getConnection().createStatement().executeUpdate(sqlString);        
    }
    
    public static void deleteAgent(Agent agent) throws Exception{
        String sqlString = "DELETE FROM [Agent] WHERE [id] = "+ agent.getId() +";";
        DBConnector.getConnection().createStatement().executeUpdate(sqlString);        
    }

    public static void editAgent(Agent agent) throws Exception {
        int genderBit = 0;
        if(agent.getGender().equals("أنثي")) genderBit = 1;
        
        int idleBit = 0;
        if (agent.isIdle()) idleBit = 1;

        String sqlString = "UPDATE [Agent] SET [Agent].[idle] = "+idleBit+","+
        "[Agent].[usrID] = '"+agent.getUsrID()+"',"+
        "[Agent].[password] = '"+agent.getPassword()+"',"+
        "[Agent].[name] = '"+agent.getName()+"',"+
        "[Agent].[NID] = '"+agent.getNid()+"',"+
        "[Agent].[gender] = "+genderBit+","+
        "[Agent].[mobile] = '"+agent.getMobile()+"',"+
        "[Agent].[birthDate] = '"+agent.getBirthDate().toString()+"',"+
        "[Agent].[email] = '"+agent.getEmail()+"',"+
        "[Agent].[cityID] = "+getCityID(agent.getCity())+","+
        "[Agent].[localAdd] = '"+agent.getLocalAddress()+"'"+
        "WHERE [Agent].[id] = "+agent.getId()+";";

        DBConnector.getConnection().createStatement().executeUpdate(sqlString);
    }
    
    ///////////////////////////////////////////////////
    
    public static Place getPlace(int id) throws Exception{
        String sqlString = "SELECT * FROM [Place] WHERE [id] = "+id+";";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(sqlString);
        Place p = new Place();
        if(res.next()){
            p.setId(res.getInt("id"));
            p.setType(res.getString("type"));
            p.setIdle(res.getBoolean("idle"));
            p.setName(res.getString("name"));
            p.setCity(getCityName(res.getInt("cityID")));
            p.setCapacity(res.getInt("capacity"));
            p.setCost(res.getDouble("cost"));
            p.setCreateDate(res.getDate("creatDate"));
        }

        return p;
    }

    public static List<Place> getResPlace(ResultSet res) throws Exception{
        List<Place> placeList = new ArrayList<>();
        while(res.next()){
            Place p = new Place();
            p.setId(res.getInt("id"));
            p.setType(res.getString("type"));
            p.setIdle(res.getBoolean("idle"));
            p.setName(res.getString("name"));
            p.setCity(getCityName(res.getInt("cityID")));
            p.setCapacity(res.getInt("capacity"));
            p.setCost(res.getDouble("cost"));
            p.setCreateDate(res.getDate("creatDate"));
            placeList.add(p);
        }

        return placeList;
    }
    
    public static void deletePlace(Place place) throws Exception{
        String sqlString = "DELETE FROM [Place] WHERE [id] = "+ place.getId() +";";
        DBConnector.getConnection().createStatement().executeUpdate(sqlString);        
    }

    public static void editPlace(Place place) throws Exception {
        int idleBit = 0;
        if (place.isIdle()) idleBit = 1;

        int cityID = getCityID(place.getCity());

        String sqlString = "UPDATE [Place] SET [Place].[idle] = "+idleBit+","+
        "[Place].[name] = '"+place.getName()+"',"+
        "[Place].[type] = '"+place.getType()+"',"+
        "[Place].[capacity] = "+place.getCapacity()+","+
        "[Place].[cost] = "+Double.toString(place.getCost())+","+
        "[Place].[cityID] = "+cityID+
        "WHERE [Place].[id] = "+place.getId()+";";

        DBConnector.getConnection().createStatement().executeUpdate(sqlString);
    }

    public static void addPlace(Place place) throws Exception{
        int cityID = getCityID(place.getCity());

        int idleBit = 0;
        if (place.isIdle()) idleBit = 1;

        String sqlString = "INSERT INTO [Place]([name], [type],"+
        "[cityID], [capacity], [cost], [idle])  values ('"+
        place.getName()+"','"+
        place.getType()+"',"+
        cityID+","+
        place.getCapacity()+","+
        Double.toString(place.getCost())+","+
        idleBit+");";

        DBConnector.getConnection().createStatement().executeUpdate(sqlString);
    }

    //////////////////////////////////////////////////
    
    public static List<Tourist> getResTourist(ResultSet res) throws Exception{
        List<Tourist> list = new ArrayList<>();

        while(res.next()){
            Tourist t = new Tourist();
            t.setId(res.getInt("id"));
            t.setPartner(getSPName(res.getInt("prtID")));
            t.setInfo(res.getString("info"));
            t.setBalance(res.getDouble("balance"));
            t.setName(res.getString("Name"));
            t.setNid(res.getString("NID"));
            if(res.getBoolean("gender")) t.setGender("أنثي");
            else t.setGender("ذكر");
            t.setMobile(res.getString("mobile"));
            t.setBirthDate(res.getDate("birthDate"));
            t.setEmail(res.getString("email"));
            t.setCity(getCityName(res.getInt("cityID")));
            t.setLocalAddress(res.getString("localAdd"));
            t.setCreateDate(res.getDate("creatDate"));
            t.setIdle(res.getBoolean("idle"));

            list.add(t);
        }

        return list;
    }
    
    public static void addTourist(Tourist tourist) throws Exception{
        int genderBit = 0;
        if (tourist.getGender().equals("أنثي")) genderBit = 1;
        int idleBit = 0;
        if (tourist.isIdle()) idleBit = 1;

        int cityID = getCityID(tourist.getCity());

        String prtIDStr = "NULL";
        int prtID = getSPID(tourist.getPartner());
        if(prtID>0) prtIDStr = Integer.toString(prtID);


        String sqlString = "INSERT INTO [Tourist]([name], [NID], [gender], [mobile], [birthDate],"+
        "[email], [cityID], [localAdd], [prtID], [info], [balance], [idle])  values ('"+
        tourist.getName()+"','"+
        tourist.getNid()+"',"+
        genderBit+",'"+
        tourist.getMobile()+"','"+
        tourist.getBirthDate().toString()+"','"+
        tourist.getEmail()+"',"+
        cityID+",'"+
        tourist.getLocalAddress()+"',"+
        prtIDStr
        +",'"+
        tourist.getInfo()+"',"+
        Double.toString(tourist.getBalance())+","+
        +idleBit+");";
        
        DBConnector.getConnection().createStatement().executeUpdate(sqlString);
    }
    
    public static void deleteTourist(Tourist tourist) throws Exception{
        String sqlString = "DELETE FROM [Tourist] WHERE [id] = "+ tourist.getId() +";";
        DBConnector.getConnection().createStatement().executeUpdate(sqlString);
    }
    
    public static void editTourist(Tourist tourist) throws Exception{
        int genderBit = 0;
        if(tourist.getGender().equals("أنثي")) genderBit = 1;
        int idleBit = 0;
        if (tourist.isIdle()) idleBit = 1;

        String prtIDStr = "NULL";
        int prtID = getSPID(tourist.getPartner());
        if(prtID>0) prtIDStr = Integer.toString(prtID);

        String sqlString = "UPDATE [Tourist] SET [Tourist].[idle] = "+idleBit+","+
        "[Tourist].[prtID] = "+prtIDStr+","+
        "[Tourist].[balance] = "+Double.toString(tourist.getBalance())+","+
        "[Tourist].[info] = '"+tourist.getInfo()+"',"+
        "[Tourist].[name] = '"+tourist.getName()+"',"+
        "[Tourist].[NID] = '"+tourist.getNid()+"',"+
        "[Tourist].[gender] = "+genderBit+","+
        "[Tourist].[mobile] = '"+tourist.getMobile()+"',"+
        "[Tourist].[birthDate] = '"+tourist.getBirthDate().toString()+"',"+
        "[Tourist].[email] = '"+tourist.getEmail()+"',"+
        "[Tourist].[cityID] = "+getCityID(tourist.getCity())+","+
        "[Tourist].[localAdd] = '"+tourist.getLocalAddress()+"'"+
        " WHERE [Tourist].[id] = "+tourist.getId()+";";

        DBConnector.getConnection().createStatement().executeUpdate(sqlString);
    }

    public static List<Guide> getGuideData() throws Exception{
        List<Guide> list = new ArrayList<>();

        String querey = "SELECT * FROM [Guide];";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(querey);
        
        while(res.next()){
            Guide g = new Guide();
            g.setId(res.getInt("id"));
            g.setSpecialty(res.getString("specialty"));
            g.setName(res.getString("Name"));
            g.setNid(res.getString("NID"));
            if(res.getBoolean("gender")) g.setGender("أنثي");
            else g.setGender("ذكر");
            g.setMobile(res.getString("mobile"));
            g.setBirthDate(res.getDate("birthDate"));
            g.setEmail(res.getString("email"));
            g.setCity(getCityName(res.getInt("cityID")));
            g.setLocalAddress(res.getString("localAdd"));
            g.setRate(res.getDouble("rate"));
            g.setCreateDate(res.getDate("creatDate"));
            g.setIdle(res.getBoolean("idle"));
 
            list.add(g);
        }

        return list;
    }

    public static void addGuide(Guide guide) throws Exception{
        int genderBit = 0;
        if (guide.getGender().equals("أنثي")) genderBit = 1;
        int idleBit = 0;
        if (guide.isIdle()) idleBit = 1;

        String sqlString = "INSERT INTO [Guide]([name], [NID], [gender], [mobile], [birthDate],"+
        "[email], [cityID], [localAdd], [specialty], [rate], [idle])  values ('"+guide.getName()+"','"+
        guide.getNid()+"',"+genderBit+",'"+guide.getMobile()+"','"+guide.getBirthDate().toString()+"','"+
        guide.getEmail()+"',"+getCityID(guide.getCity())+",'"+guide.getLocalAddress()+"','"+guide.getSpecialty()+
        "','"+Double.toString(guide.getRate())+"',"+idleBit+");";

        DBConnector.getConnection().createStatement().executeUpdate(sqlString);
    }
    
    public static void deleteGuide(Guide guide) throws Exception{
        String sqlString = "DELETE FROM [Guide] WHERE [id] = "+ guide.getId() +";";
        DBConnector.getConnection().createStatement().executeUpdate(sqlString);  
    }
    
    public static void editGuide(Guide guide) throws Exception{
        int genderBit = 0;
        if(guide.getGender().equals("أنثي")) genderBit = 1;
        
        int idleBit = 0;
        if (guide.isIdle()) idleBit = 1;

        String sqlString = "UPDATE [Guide] SET [Guide].[idle] = "+idleBit+","+
        "[Guide].[specialty] = '"+guide.getSpecialty()+"',"+
        "[Guide].[rate] = '"+Double.toString(guide.getRate())+"',"+
        "[Guide].[name] = '"+guide.getName()+"',"+
        "[Guide].[NID] = '"+guide.getNid()+"',"+
        "[Guide].[gender] = "+genderBit+","+
        "[Guide].[mobile] = '"+guide.getMobile()+"',"+
        "[Guide].[birthDate] = '"+guide.getBirthDate().toString()+"',"+
        "[Guide].[email] = '"+guide.getEmail()+"',"+
        "[Guide].[cityID] = "+getCityID(guide.getCity())+","+
        "[Guide].[localAdd] = '"+guide.getLocalAddress()+"'"+
        " WHERE [Guide].[id] = "+guide.getId()+";";
        
        DBConnector.getConnection().createStatement().executeUpdate(sqlString);
    }

    public static List<Travel> getResTravel(ResultSet res) throws Exception{
        List<Travel> list = new ArrayList<>();
            
        while (res.next()) {
            Travel t = new Travel();
            t.setId(res.getInt("id"));
            t.setTitle(res.getString("title"));
            t.setCreatDate(res.getDate("creatDate"));
            t.setStartDate(res.getDate("startDate"));
            t.setEndDate(res.getDate("endDate"));
            t.setPrice(res.getDouble("price"));
            t.setIdle(res.getBoolean("idle"));
            t.setCampaign(getResCampaign(getRegistration("Campaign",res.getInt("id"))));
            t.setRegTourist(getResRegTourist(getRegistration("RegTourist",res.getInt("id"))));
            t.setRegGuide(getResRegGuide(getRegistration("RegGuide",res.getInt("id"))));
            t.setRegHostel(getResRegHostel(getRegistration("RegHostel",res.getInt("id"))));
            t.setRegPLace(getResRegPlace(getRegistration("RegPlace",res.getInt("id"))));
            t.setRegTransport(getResRegTransport(getRegistration("RegTransport",res.getInt("id"))));
            
            list.add(t);
        }

        return list;
    }
    
    public static Travel getTravel(int trvID) throws Exception{
        Travel t = new Travel();

        String sqlString = "SELECT * FROM [Travel] WHERE [id] ="+trvID+";";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(sqlString);
        if(res.next()){
            t.setId(res.getInt("id"));
            t.setTitle(res.getString("title"));
            t.setCreatDate(res.getDate("creatDate"));
            t.setStartDate(res.getDate("startDate"));
            t.setEndDate(res.getDate("endDate"));
            t.setPrice(res.getDouble("price"));
            t.setIdle(res.getBoolean("idle"));
            t.setCampaign(getResCampaign(getRegistration("Campaign",res.getInt("id"))));
            t.setRegTourist(getResRegTourist(getRegistration("RegTourist",res.getInt("id"))));
            t.setRegGuide(getResRegGuide(getRegistration("RegGuide",res.getInt("id"))));
            t.setRegHostel(getResRegHostel(getRegistration("RegHostel",res.getInt("id"))));
            t.setRegPLace(getResRegPlace(getRegistration("RegPlace",res.getInt("id"))));
            t.setRegTransport(getResRegTransport(getRegistration("RegTransport",res.getInt("id"))));
        }
 
        return t;
    }

    public static void deleteTravel(Travel travel) throws Exception{
        String sqlString =
                "DELETE FROM [RegTourist] WHERE [trvID] = "+ travel.getId() +";"+
                "DELETE FROM [RegTransport] WHERE [trvID] = "+ travel.getId() +";"+
                "DELETE FROM [RegHostel] WHERE [trvID] = "+ travel.getId() +";"+
                "DELETE FROM [Campain] WHERE [trvID] = "+ travel.getId() +";"+
                "DELETE FROM [RegGuide] WHERE [trvID] = "+ travel.getId() +";"+
                "DELETE FROM [RegPlace] WHERE [trvID] = "+ travel.getId() +";"+
                "DELETE FROM [Travel] WHERE [id] = "+ travel.getId() +";";
        
        DBConnector.getConnection().createStatement().executeUpdate(sqlString);  
    }
    
    public static void editTravel(Travel travel) throws Exception{
        int idleBit = 0;
        if (travel.isIdle()) idleBit = 1;

        String sqlString = "UPDATE [Travel] SET [Travel].[idle] = "+idleBit+","+
        "[Travel].[title] = '"+travel.getTitle()+"',"+
        "[Travel].[price] = "+Double.toString(travel.getPrice())+","+
        "[Travel].[startDate] = '"+travel.getStartDate().toString()+"',"+ 
        "[Travel].[endDate] = '"+travel.getEndDate().toString()+"',"+
        "[Travel].[creatDate] = '"+travel.getCreatDate().toString()+"',"+
        " WHERE [Travel].[id] = "+travel.getId()+";";

        DBConnector.getConnection().createStatement().executeUpdate(sqlString);
    }
    
    public static void addTravel(Travel travel) throws Exception{
        int idleBit = 0;
        if (travel.isIdle()) idleBit = 1;

        String sqlString = "INSERT INTO [Travel]([title], [startDate],"+
        "[endDate], [price], [idle]) values ('"+
        travel.getTitle()+"','"+
        travel.getStartDate().toString()+"','"+
        travel.getEndDate().toString()+"','"+
        Double.toString(travel.getPrice())+"',"+
        idleBit+");";

        DBConnector.getConnection().createStatement().executeUpdate(sqlString);
    }
 
    public static List<Phone> getResPhone(ResultSet res) throws Exception{
        List<Phone> list = new ArrayList<>();

        while (res.next()){
            Phone p = new Phone();
            p.setId(res.getInt("id"));
            p.setFax(res.getBoolean("fax"));
            p.setPhone(res.getString("phone"));
            
            list.add(p);
        }

        return list;
    }

    public static String getPhone(int id) throws Exception{
        String str = "";
        List<Phone> phones = getResPhone(getSelectiveData("Phone", "id", id));
        
        for (Phone phone : phones) {
            str += phone.getPhone();
            if(phone.isFax()) str += " : fax";
            str += "\n";
        }

        return str;
    }

    public static void addServiceProvider(ServiceProvider svp) throws Exception{
        int idleBit = 0;
        if (svp.isIdle()) idleBit = 1;

        String sqlString = "INSERT INTO [ServiceProvider]([class], [name], [CRN], [email], [cityID],"+
        " [localAdd], [type], [idle]) VALUES ('"+
        svp.getCls()+"','"+
        svp.getName()+"','"+
        svp.getCrn()+"','"+
        svp.getEmail()+"',"+
        getCityID(svp.getCity())+",'"+
        svp.getLocalAddress()+"','"+
        svp.getType()+"',"+
        idleBit+");";
    
        DBConnector.getConnection().createStatement().executeUpdate(sqlString);
    }
    
    public static void editServiceProvider(ServiceProvider svp) throws Exception{
        int idleBit = 0;
        if (svp.isIdle()) idleBit = 1;
        
        String sqlString = "UPDATE [ServiceProvider] SET [ServiceProvider].[class] = '"+svp.getCls()+"',"+
        "[ServiceProvider].[name] = '"+svp.getName()+"',"+
        "[ServiceProvider].[CRN] = '"+svp.getCrn()+"',"+
        "[ServiceProvider].[email] = '"+svp.getEmail()+"',"+
        "[ServiceProvider].[cityID] = "+getCityID(svp.getCity())+","+
        "[ServiceProvider].[localAdd] = '"+svp.getLocalAddress()+"',"+
        "[ServiceProvider].[type] = '"+svp.getType()+"',"+
        "[ServiceProvider].[idle] = "+idleBit+" "+
        "WHERE [ServiceProvider].[id] = "+svp.getId()+";";
        
        DBConnector.getConnection().createStatement().executeUpdate(sqlString);
    }

    public static void deleteServiceProvider(ServiceProvider svp) throws Exception{
        String sqlString = "DELETE FROM [ServiceProvider] WHERE [id] = "+svp.getId()+";";
        DBConnector.getConnection().createStatement().executeUpdate(sqlString); 
    }

    public static void addPartner(Partner prt) throws Exception{
        int idleBit = 0;
        if (prt.isIdle()) idleBit = 1;

        String sqlString = "INSERT INTO [ServiceProvider]([class], [name], [CRN], [email], [cityID],"+
        " [localAdd], [type], [idle], [discount]) VALUES ('"+
        prt.getCls()+"','"+
        prt.getName()+"','"+
        prt.getCrn()+"','"+
        prt.getEmail()+"',"+
        getCityID(prt.getCity())+",'"+
        prt.getLocalAddress()+"','"+
        prt.getType()+"',"+
        idleBit+","+
        prt.getDiscount()+");";
    
        DBConnector.getConnection().createStatement().executeUpdate(sqlString);
    }
    
    public static void editPartner(Partner prt) throws Exception{
        int idleBit = 0;
        if (prt.isIdle()) idleBit = 1;
        
        String sqlString = "UPDATE [ServiceProvider] SET [ServiceProvider].[class] = '"+prt.getCls()+"',"+
        "[ServiceProvider].[name] = '"+prt.getName()+"',"+
        "[ServiceProvider].[CRN] = '"+prt.getCrn()+"',"+
        "[ServiceProvider].[email] = '"+prt.getEmail()+"',"+
        "[ServiceProvider].[cityID] = "+getCityID(prt.getCity())+","+
        "[ServiceProvider].[localAdd] = '"+prt.getLocalAddress()+"',"+
        "[ServiceProvider].[type] = '"+prt.getType()+"',"+
        "[ServiceProvider].[idle] = "+idleBit+" "+
        "[ServiceProvider].[discount] = "+prt.getDiscount()+" "+
        "WHERE [ServiceProvider].[id] = "+prt.getId()+";";
        
        DBConnector.getConnection().createStatement().executeUpdate(sqlString);
    }

    public static void deletePartner(Partner prt) throws Exception{
        String sqlString = "DELETE FROM [ServiceProvider] WHERE [id] = "+prt.getId()+";";
        DBConnector.getConnection().createStatement().executeUpdate(sqlString); 
    }

}
