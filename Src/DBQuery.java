import java.sql.Date;
import java.sql.ResultSet;
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

    public static int getPartnerID(String partner) throws Exception{
        int id = -1;
        
        String querey = "SELECT [id] FROM [ServiceProvider] WHERE [name] = '"+ partner +"';";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(querey);
        if(res.next())
            id = res.getInt("id");

        return id;
    }

    public static String getPartnerName(int partnerID) throws Exception{
        String name = "";

        String querey = "SELECT [name] FROM [ServiceProvider] WHERE [id] = "+ partnerID +";";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(querey);
        if(res.next())
            name = res.getString("name");

        return name;
    }


    public static List<String> getPartnerData() throws Exception{
        List<String> list = new ArrayList<>();
        
        String sqlString = "SELECT DISTINCT [name] FROM [ServiceProvider] WHERE [class] = 'prt';";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(sqlString);
        while(res.next())
            list.add(res.getString("name"));

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

    /*
    public static int getAgentRoleID(String role) throws Exception{
        int id = -1;
        String querey = "SELECT [id] FROM [AgentRate] WHERE [role] = '"+ role +"';";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(querey);
        if(res.next())
            id = res.getInt("id");
            return id;
        }
        
    public static String getAgentRole(int id) throws Exception{
        String role = "";
        String querey = "SELECT [role] FROM [AgentRate] WHERE [id] = "+ id +";";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(querey);
        if(res.next())
            role = res.getString("role");
            
        return role;
    }

    public static List<String> getAgentRoleData() throws Exception{
        List<String> list = new ArrayList<>();
        String querey = "SELECT DISTINCT [role] FROM [AgentRate];";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(querey);
        while(res.next())
            list.add(res.getString("role"));
        return list;
    }*/

    public static List<Agent> getAgentData() throws Exception{
        List<Agent> agentList = new ArrayList<>();

        String querey = "SELECT * FROM [Agent];";
        
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(querey);
        
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
            if(res.getBoolean("gender")) a.setGender("Female");
            else a.setGender("Male");

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
    
    public static void deleteAgent(Agent agent) throws Exception{
        String sqlString = "DELETE FROM [Agent] WHERE [id] = "+ agent.getId() +";";
        DBConnector.getConnection().createStatement().executeUpdate(sqlString);        
    }

    public static void editAgent(Agent agent) throws Exception {
        int genderBit = 0;
        if(agent.getGender().equals("Female")) genderBit = 1;
        
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

        " WHERE [Agent].[id] = "+agent.getId()+";";
        DBConnector.getConnection().createStatement().executeUpdate(sqlString);
    }

    public static List<Tourist> getTouristsData() throws Exception{
        List<Tourist> list = new ArrayList<>();

        String querey = "SELECT * FROM [Tourist];";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(querey);
        
        while(res.next()){
            Tourist t = new Tourist();
            t.setId(res.getInt("id"));
            t.setPartner(getPartnerName(res.getInt("prtID")));
            t.setInfo(res.getString("info"));
            t.setBalance(res.getDouble("balance"));
            t.setName(res.getString("Name"));
            t.setNid(res.getString("NID"));
            if(res.getBoolean("gender")) t.setGender("Female");
            else t.setGender("Male");
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
        if (tourist.getGender().equals("Femaile")) genderBit = 1;
        int idleBit = 0;
        if (tourist.isIdle()) idleBit = 1;

        int cityID = getCityID(tourist.getCity());

        String prtIDStr = "NULL";
        int prtID = getPartnerID(tourist.getPartner());
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
        if(tourist.getGender().equals("Female")) genderBit = 1;
        
        int idleBit = 0;
        if (tourist.isIdle()) idleBit = 1;

        String prtIDStr = "NULL";
        int prtID = getPartnerID(tourist.getPartner());
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
            if(res.getBoolean("gender")) g.setGender("Female");
            else g.setGender("Male");
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
        if (guide.getGender().equals("Femaile")) genderBit = 1;
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
        if(guide.getGender().equals("Female")) genderBit = 1;
        
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

    public static List<Travel> getTravelData() throws Exception{
        List<Travel> list = new ArrayList<>();

        String sqlString = "SELECT * FROM [Travel];";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(sqlString);
        while (res.next()) {
            Travel t = new Travel();
            t.setId(res.getInt("id"));
            t.setTitle(res.getString("title"));
            t.setCreatDate(res.getDate("creatDate"));
            t.setIdle(res.getBoolean("idle"));
            t.setStartDate(res.getDate("startDate"));
            t.setEndDate(res.getDate("endDate"));
            t.setPrice(res.getDouble("price"));
            list.add(t);
        }

        return list;
    }

    public static String getTravelReport(int travelID) throws Exception{
        String str = "";
        
        // -- عنوان الرحلة
        // SELECT title FROM Travel WHERE id = 2;
        str += "/*  عنوان الرحلة  */\n";
        String sql = "SELECT [title] FROM [Travel] WHERE [id] = "+travelID+";";
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(sql);
        res.next();
        str += res.getString("title");
        str += "\n\n";


        str += "/*  تاريخ الإنشاء  */\n";
        sql = "SELECT [creatDate] FROM [Travel] WHERE [id] = "+travelID+";";
        res = DBConnector.getConnection().createStatement().executeQuery(sql);
        res.next();
        str += res.getString("creatDate");
        str += "\n\n";

        str += "/*  الحالة  */\n";
        sql = "SELECT [idle] FROM [Travel] WHERE [id] = "+travelID+";";
        res = DBConnector.getConnection().createStatement().executeQuery(sql);
        res.next();
        str += res.getString("idle");
        str += "\n\n";

        str += "/*  تاريخ بداية الرحل  */\n";
        sql = "SELECT [startDate] FROM [Travel] WHERE [id] = "+travelID+";";
        res = DBConnector.getConnection().createStatement().executeQuery(sql);
        res.next();
        str += res.getDate("startDate").toString();
        str += "\n\n";
        
        str += "/*  تاريخ نهاية الرحل  */\n";
        sql = "SELECT [endDate] FROM [Travel] WHERE [id] = "+travelID+";";
        res = DBConnector.getConnection().createStatement().executeQuery(sql);
        res.next();
        str += res.getDate("endDate").toString();
        str += "\n\n";

        str += "/*  عدد أيام الرحلة  */\n";
        sql = "SELECT DATEDIFF(DAY, (SELECT [startDate] FROM Travel WHERE [id] = "+travelID+") ,"+
        "(SELECT [endDate] FROM [Travel] WHERE id = "+travelID+")) as 'NumOfDays'";
        res = DBConnector.getConnection().createStatement().executeQuery(sql);
        res.next();
        str += res.getInt("NumOfDays");
        str += "\n\n";
        
        str += "/*  سعر الرحلة للفرد  */\n";
        sql = "SELECT [price] FROM [Travel] WHERE [id] = "+travelID+";";
        res = DBConnector.getConnection().createStatement().executeQuery(sql);
        res.next();
        str += res.getDouble("price");
        str += "\n\n";
       
        str += "/*  إجمالي عدد السياح المشتركين  */\n";
        sql = "SELECT COUNT([trvID]) as 'count' FROM RegTourist WHERE [trvID] = "+travelID+";";
        res = DBConnector.getConnection().createStatement().executeQuery(sql);
        res.next();
        str += res.getInt("count");
        str += "\n\n";
        
        str += "/*  إجمالي عدد وسائل النقل المشاركة  */\n";
        sql = "SELECT COUNT([totalCost]) as 'count' FROM [RegTransport] WHERE [trvID] = "+travelID+";";
        res = DBConnector.getConnection().createStatement().executeQuery(sql);
        res.next();
        str += res.getInt("count");
        str += "\n\n";
        
        str += "/*  التكلفة الإجمالية لوسائل النقل المشاركة  */\n";
        sql = "SELECT SUM([totalCost]) 'cost' FROM RegTransport WHERE [trvID] = "+travelID+";";
        res = DBConnector.getConnection().createStatement().executeQuery(sql);
        res.next();
        str += res.getInt("cost");
        str += "\n\n";
        
        str += "/*  إجمالي عدد أماكن الإقامة المحجوزة  */\n";
        sql = "SELECT COUNT([trvID]) 'count' FROM [RegHostel] WHERE [trvID] = "+travelID+";";
        res = DBConnector.getConnection().createStatement().executeQuery(sql);
        res.next();
        str += res.getInt("count");
        str += "\n\n";
        
        str += "/*  التكلفة الإجمالية لأماكن الإقامة المحجوزة  */\n";
        sql = "SELECT SUM([totalCost]) 'cost' FROM [RegHostel] WHERE [trvID] = "+travelID+";";
        res = DBConnector.getConnection().createStatement().executeQuery(sql);
        res.next();
        str += res.getDouble("cost");
        str += "\n\n";
        
        str += "/*  إجمالي عدد المرشدين السياحين  */\n";
        sql = "SELECT COUNT([trvID]) 'count' FROM [RegGuide] WHERE [trvID] = "+travelID+";";
        res = DBConnector.getConnection().createStatement().executeQuery(sql);
        res.next();
        str += res.getInt("count");
        str += "\n\n";
        
        str += "/*  التكلفة الإجمالية للمرشدين السياحين المشاركين  */\n";
        sql = "SELECT SUM([totalCost]) 'cost' FROM [RegGuide] WHERE [trvID] = "+travelID+";";
        res = DBConnector.getConnection().createStatement().executeQuery(sql);
        res.next();
        str += res.getDouble("cost");
        str += "\n\n";
        
        str += "/*  إجمالي عدد الأماكن السياحية المسجلة  */\n";
        sql = "SELECT COUNT([trvID]) 'count' FROM [RegPlace] WHERE [trvID] = "+travelID+";";
        res = DBConnector.getConnection().createStatement().executeQuery(sql);
        res.next();
        str += res.getInt("count");
        str += "\n\n";

        str += "/*  التكلفة الإجمالية لزيارة للأماكن السياحية  */\n";
        sql = "SELECT (SELECT SUM(cost) FROM [Place] WHERE [id] in "+
        "(SELECT [plcID] FROM [RegPlace] WHERE [trvID] = 2)) * "+
        "(SELECT COUNT([trvID]) FROM [RegTourist] WHERE [trvID] = "+travelID+") 'cost';";
        res = DBConnector.getConnection().createStatement().executeQuery(sql);
        res.next();
        str += res.getDouble("cost");
        str += "\n\n";

        str += "/*  إجمالي عدد الأعلانات المنشورة  */\n";
        sql = "SELECT COUNT(trvID) 'count' FROM Campaign WHERE trvID = "+travelID+";";
        res = DBConnector.getConnection().createStatement().executeQuery(sql);
        res.next();
        str += res.getInt("count");
        str += "\n\n";

        str += "/*  التكلفة الإجمالية للأعلانات المنشورة  */\n";
        sql = "SELECT SUM([cost]) 'cost' FROM [Campaign] WHERE [trvID] = "+travelID+";";
        res = DBConnector.getConnection().createStatement().executeQuery(sql);
        res.next();
        str += res.getDouble("cost");
        str += "\n\n";

        str += "/*  إجمالي عائدات الرحلة  */\n";
        sql = "SELECT SUM(actualProfit) 'profit' FROM RegTourist WHERE trvID = "+travelID+";";
        res = DBConnector.getConnection().createStatement().executeQuery(sql);
        res.next();
        str += res.getDouble("profit");
        str += "\n\n";

        str += "/*  إجمالي تكلفة الرحلة  */\n";
        sql = "DECLARE  @id AS int = "+travelID+
        "DECLARE  @cost AS MONEY = (SELECT SUM(totalCost) FROM RegTransport WHERE trvID = @id) +"+
        "(SELECT SUM(totalCost) FROM RegHostel WHERE trvID = @id) +"+
        "((SELECT SUM(cost) FROM Place WHERE id in (SELECT plcID FROM RegPlace WHERE trvID = @id))*"+
        "(SELECT COUNT(trvID) FROM RegTourist WHERE trvID = @id)) +"+
        "(SELECT SUM(totalCost) FROM RegGuide WHERE trvID = @id) +"+
        "(SELECT SUM(cost) FROM Campaign WHERE trvID = @id)"+
        "SELECT @cost 'totalcost';";
        res = DBConnector.getConnection().createStatement().executeQuery(sql);
        res.next();
        str += res.getDouble("totalcost");
        str += "\n\n";
        
        str += "/*  صافي ربح الرحلة  */\n";
        sql = "DECLARE  @trvid AS int = "+travelID+
        "DECLARE  @trvprofit AS MONEY = (SELECT SUM(actualProfit) FROM RegTourist WHERE trvID = @trvid)-"+
        "((SELECT SUM(totalCost) FROM RegTransport WHERE trvID = @trvid)+"+
        "(SELECT SUM(totalCost) FROM RegHostel WHERE trvID = @trvid) +"+
        "((SELECT SUM(cost) FROM Place WHERE id in (SELECT plcID FROM RegPlace WHERE trvID = @trvid))*"+
        "(SELECT COUNT(trvID) FROM RegTourist WHERE trvID = @trvid))+"+
        "(SELECT SUM(totalCost) FROM RegGuide WHERE trvID = @trvid) +"+
        "(SELECT SUM(cost) FROM Campaign WHERE trvID = @trvid))"+
        "SELECT @trvprofit 'totalprofit';";
        res = DBConnector.getConnection().createStatement().executeQuery(sql);
        res.next();
        str += res.getDouble("totalprofit");
        str += "\n\n";


        return str;
    }
}
