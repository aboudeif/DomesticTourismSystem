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
        prtIDStr+",'"+
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

}
