import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
    }

    public static List<Agent> getAgentData() throws Exception{
        List<Agent> agentList = new ArrayList<>();

        String querey = "SELECT * FROM [Agent];";
        
        ResultSet res = DBConnector.getConnection().createStatement().executeQuery(querey);
        
        while(res.next()){
            Agent a = new Agent();
            a.setId(res.getInt("id"));
            a.setName(res.getString("name"));
            a.setNid(res.getString("NID"));
            a.setRoleID(res.getInt("roleID"));
            a.setUsrID(res.getString("usrID"));
            a.setPassword(res.getString("password"));
            a.setMobile(res.getString("mobile"));
            a.setBirthDate(res.getDate("birthDate"));
            a.setLocalAddress(res.getString("localAdd"));
            a.setCityID(res.getInt("cityID"));
            a.setEmail(res.getString("email"));
            a.setCreateDate(res.getDate("creatDate"));
            if(res.getBoolean("gender")) a.setGender("Female");
            else a.setGender("Male");

            agentList.add(a);
        }

        return agentList;
    }

    public static void addAgent(String name, String nid, boolean gender, String mobile,
        Date birthDate, String email, int cityID, String localAddress, String usrID,
        String password , int roleID) throws Exception{
        
        int genderBit = 0;
        if (gender) genderBit = 1;

        String sqlString = "INSERT INTO [Agent]([name], [NID], gender, mobile, birthDate,"+
        "email, cityID, localAdd, usrID, password, roleID)  values ('"+name+"','"+nid+"',"+genderBit+
        ",'"+mobile+"','"+birthDate.toString()+"','"+email+"',"+cityID+",'"+localAddress+"','"+usrID+
        "','"+password+"',"+roleID+");";

        DBConnector.getConnection().createStatement().executeUpdate(sqlString);        
    }
    
    public static void deleteAgent(Agent agent) throws Exception{
        String sqlString = "DELETE FROM [Agent] WHERE [id] = "+ agent.getId() +";";
        DBConnector.getConnection().createStatement().executeUpdate(sqlString);        
    }

    public static void editAgent(Agent agent) throws Exception {
        int genderBit = 0;
        if(agent.getGender().equals("Female")) genderBit = 1;
        
        String sqlString = "UPDATE [Agent] SET [Agent].[roleID] = "+agent.getRoleID()+","+
        "[Agent].[usrID] = '"+agent.getUsrID()+"',"+
        "[Agent].[password] = '"+agent.getPassword()+"',"+
        "[Agent].[name] = '"+agent.getName()+"',"+
        "[Agent].[NID] = '"+agent.getNid()+"',"+
        "[Agent].[gender] = "+genderBit+","+
        "[Agent].[mobile] = '"+agent.getMobile()+"',"+
        "[Agent].[birthDate] = '"+agent.getBirthDate().toString()+"',"+
        "[Agent].[email] = '"+agent.getEmail()+"',"+
        "[Agent].[cityID] = "+agent.getCityID()+","+
        "[Agent].[localAdd] = '"+agent.getLocalAddress()+"'"+

        " WHERE [Agent].[id] = "+agent.getId()+";";
        DBConnector.getConnection().createStatement().executeUpdate(sqlString);
    }
}
