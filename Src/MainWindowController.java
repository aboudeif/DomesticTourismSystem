import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainWindowController implements Initializable {
    private static MainWindowController instance;
    @FXML
    private TableView<Tourist> touristTable;
    @FXML
    private TableView<Guide> guideTable;
    @FXML
    private TableView<Agent> agentTable;
    @FXML
    private TableView<Schedule> scheduleTable;
    @FXML
    private TableView<Travel> travelTable;
    @FXML
    private MenuBar menuBar;
    @FXML
    private TabPane tabPane;
    @FXML
    private Tab agentTab;
    @FXML
    private Tab touristTab;
    @FXML
    private Tab guideTab;
    @FXML
    private Tab travelTab;
    @FXML
    private BorderPane borderPane;
    @FXML
    private Tab scheduleTab;
    @FXML
    private Tab placeTab;
    @FXML
    private TableView<Place> placeTable;
    BorderPane touristPane;
    @FXML
    private Tab partnerTab;
    @FXML
    private TableView<Partner> partnerTable;
    @FXML
    private Tab travelReportTab;
    @FXML
    private AnchorPane travelReportPane;
    @FXML
    private ComboBox<String> agentSearchComboBox;
    @FXML
    private TextField agentSearchText;
    @FXML
    private ComboBox<String> touristSearchComboBox;
    @FXML
    private TextField touristSearchText;
    @FXML
    private ComboBox<String> placeSearchComboBox;
    @FXML
    private TextField placeSearchText;
    @FXML
    private ComboBox<String> guideSearchComboBox;
    @FXML
    private TextField guideSearchText;
    @FXML
    private ComboBox<String> travelSearchComboBox;
    @FXML
    private TextField travelSearchText;
    @FXML
    private Tab transportTab;
    @FXML
    private ComboBox<String> transportSearchComboBox;
    @FXML
    private TextField transportSearchText;
    @FXML
    private TableView<Transport> transportTable;
    @FXML
    private Tab hostelTab;
    @FXML
    private ComboBox<String> hostelSearchComboBox;
    @FXML
    private TextField hostelSearchText;
    @FXML
    private TableView<Hostel> hostelTable;
    @FXML
    private ComboBox<String> partnerSearchComboBox;
    @FXML
    private TextField partnerSearchText;
    @FXML
    private Tab transportServiceTab;
    @FXML
    private ComboBox<String> transportServiceSearchComboBox;
    @FXML
    private TextField transportServiceSearchText;
    @FXML
    private TableView<TransportService> transportServiceTable;
    @FXML
    private Tab hostelServiceTab;
    @FXML
    private ComboBox<String> hostelServiceSearchComboBox;
    @FXML
    private TextField hostelServiceSearchText;
    @FXML
    private TableView<HostelService> hostelServiceTable;
    @FXML
    private ComboBox<String> adServiceSearchComboBox;
    @FXML
    private TextField adServiceSearchText;
    @FXML
    private TableView<AdService> adServiceTable;
    @FXML
    private ComboBox<String> adSearchComboBox;
    @FXML
    private TextField adSearchText;
    @FXML
    private TableView<Advertisement> adTable;
    @FXML
    private Tab aboutTab;
    @FXML
    private AnchorPane aboutPane;
    @FXML
    private Tab registrationTab;
    @FXML
    private AnchorPane registrationPane;
    @FXML
    private Tab regTouristTab;
    @FXML
    private TableView<RegTourist> regTouristTable;
    @FXML
    private Tab regPlaceTab;
    @FXML
    private TableView<RegPlace> regPlaceTable;
    @FXML
    private Tab regGuideTab;
    @FXML
    private TableView<RegGuide> regGuideTable;
    @FXML
    private Tab regTransportTab;
    @FXML
    private TableView<RegTransport> regTransportTable;
    @FXML
    private Tab regHostelTab;
    @FXML
    private TableView<RegHostel> regHostelTable;
    @FXML
    private Tab adTab;
    @FXML
    private Tab regcampaignTab;
    @FXML
    private TableView<Campaign> regCampaignTable;
    @FXML
    private Tab adServiceTab;
    @FXML
    private TextField registerationSearchText;
    @FXML
    private TabPane registerationTabPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Store the Instance
        instance = this;

        // init database tables
        initRegTouristTableView();
        initRegPlaceTableView();
        initRegGuideTableView();
        initRegTransportTableView();
        initAdServiceTableView();
        initRegHostelTableView();
        initHostelServiceTableView();
        initRegCampaignTableView();
        initTransportServiceTableView();
        initPartnerTableView();
        initAgentTableView();
        initHostelTableView();
        initAdvertisementTableView();
        initTouristTableView();
        initGuideTableView();
        initTransportTableView();
        initTravelTableView();
        initPlaceTableView();
        tabPane.getTabs().clear();
        initScheduleTableView();
        tabPane.getTabs().add(0,scheduleTab);
        
    }
   
    @FXML
    void refreshAgent(ActionEvent event) {
        refreshAgentTableView();
    }

    public static MainWindowController getInstance() {
        return instance;
    }

    @FXML
    void deleteAgent(ActionEvent event) {
        Agent agent = agentTable.getSelectionModel().getSelectedItem();
        try {
            DBQuery.deleteAgent(agent);
        } catch (Exception e) {
        }
        refreshAgentTableView();
    }

    @FXML
    void editAgent(ActionEvent event) {
        Agent agent = agentTable.getSelectionModel().getSelectedItem();
        if (agent == null)
            return;
        
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AgentWindow.fxml"));
            Parent root = loader.load();
            AgentWindowController controller = loader.getController();
            controller.setAgent(agent);
            controller.setEditOp(true);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setTitle("Domestic Tourism System");
            stage.getIcons().add(new Image("/icon.png"));
            stage.setScene(scene);
            stage.showAndWait();
        }catch(Exception e){
        }
    }

    @FXML
    void addAgent(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AgentWindow.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setTitle("Domestic Tourism System");
            stage.getIcons().add(new Image("/icon.png"));
            stage.setScene(scene);
            stage.showAndWait();
        }catch(Exception e){
        }
    }

    @FXML
    void refreshTourist(ActionEvent event) {
        refreshTouristTableView();
    }
    
    @FXML
    void deleteTourist(ActionEvent event) {
        Tourist tourist = touristTable.getSelectionModel().getSelectedItem();
        try {
            DBQuery.deleteTourist(tourist);
        } catch (Exception e) {
        }
        refreshTouristTableView();
    }
    
    @FXML
    void editTourist(ActionEvent event) {
        Tourist tourist = touristTable.getSelectionModel().getSelectedItem();
        if (tourist == null)
            return;
        
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TouristWindow.fxml"));
            Parent root = loader.load();
            TouristWindowController controller = loader.getController();
            controller.setTourist(tourist);
            controller.setEditOp(true);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Domestic Tourism System");
            stage.getIcons().add(new Image("/icon.png"));
            stage.setResizable(false);
            stage.showAndWait();
        }catch(Exception e){}
       /*Parent root = null;
        try{ 
            root = FXMLLoader.load(getClass().getResource("TouristWindow.fxml"));
        }catch(IOException ex){
    Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null,ex);}
        touristPane.setLeft(null);
        touristPane.setLeft(root);*/
        
    }
    
    @FXML
    void addTourist(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TouristWindow.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Domestic Tourism System");
            stage.getIcons().add(new Image("/icon.png"));
            stage.setResizable(false);
            stage.showAndWait();
        }catch(Exception e){
        }/*
        Parent root = null;
        try{ 
            root = FXMLLoader.load(getClass().getResource("TouristWindow.fxml"));
        }catch(IOException ex){
    Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null,ex);}
        touristPane.setLeft(null);
        touristPane.setLeft(root);*/
    }

    @FXML
    void refreshGuide(ActionEvent event) {
        refreshGuideTableView();
    }
    
    @FXML
    void deleteGuide(ActionEvent event) {
        Guide guide = guideTable.getSelectionModel().getSelectedItem();
        try {
            DBQuery.deleteGuide(guide);
        } catch (Exception e) {
        }
        refreshGuideTableView();
    }
    
    @FXML
    void editGuide(ActionEvent event) {
        Guide guide = guideTable.getSelectionModel().getSelectedItem();
        if (guide == null)
            return;
        
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GuideWindow.fxml"));
            Parent root = loader.load();
            GuideWindowController controller = loader.getController();
            controller.setGuide(guide);
            controller.setEditOp(true);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setTitle("Domestic Tourism System");
            stage.getIcons().add(new Image("/icon.png"));
            stage.setScene(scene);
            stage.showAndWait();
        }catch(Exception e){
        }
    }
    
    @FXML
    void addGuide(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GuideWindow.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setTitle("Domestic Tourism System");
            stage.getIcons().add(new Image("/icon.png"));
            stage.setScene(scene);
            stage.showAndWait();
        }catch(Exception e){
        }
    }

    //////////////////////////////////////////
    @FXML
    void refreshPlace(ActionEvent event) {
        refreshPlaceTableView();
    }
    
    @FXML
    void deletePlace(ActionEvent event) {
        Place place = placeTable.getSelectionModel().getSelectedItem();
        try {
            DBQuery.deletePlace(place);
        } catch (Exception e) {
        }
        refreshPlaceTableView();
    }
    
    @FXML
    void editPlace(ActionEvent event) {
        Place place = placeTable.getSelectionModel().getSelectedItem();
        if (place == null)
            return;
        
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PlaceWindow.fxml"));
            Parent root = loader.load();
            PlaceWindowController controller = loader.getController();
            controller.setPlace(place);
            controller.setEditOp(true);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setTitle("Domestic Tourism System");
            stage.getIcons().add(new Image("/icon.png"));
            stage.setScene(scene);
            stage.showAndWait();
        }catch(Exception e){
        }
    }
    
    @FXML
    void addPlace(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PlaceWindow.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setTitle("Domestic Tourism System");
            stage.getIcons().add(new Image("/icon.png"));
            stage.setScene(scene);
            stage.showAndWait();
        }catch(Exception e){
        }
    }
    ////////////////==========================
    @FXML
    void refreshTravel(ActionEvent event) {
        refreshTravelTableView();
    }
    
    @FXML
    void deleteTravel(ActionEvent event) {
        Travel travel = travelTable.getSelectionModel().getSelectedItem();
        try {
            DBQuery.deleteTravel(travel);
        } catch (Exception e) {
        }
        refreshPlaceTableView();
    }
    
    @FXML
    void editTravel(ActionEvent event) {
        Travel travel = travelTable.getSelectionModel().getSelectedItem();
        if (travel == null)
            return;
        
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TravelWindow.fxml"));
            Parent root = loader.load();
            TravelWindowController controller = loader.getController();
            controller.setTravel(travel);
            controller.setEditOp(true);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setTitle("Domestic Tourism System");
            stage.getIcons().add(new Image("/icon.png"));
            stage.setScene(scene);
            stage.showAndWait();
        }catch(Exception e){
        }
    }
    
    @FXML
    private void RegTravel(ActionEvent event) throws Exception  {
        Travel travel = travelTable.getSelectionModel().getSelectedItem();
              Travel.setSelectedTravel(travel);
        if (travel == null)
            return;
        
        initRegTouristTableView();
        
        initRegPlaceTableView();
        
        initRegGuideTableView();
        
        initRegTransportTableView();
        
        initRegHostelTableView();
        
        initRegCampaignTableView();
      
        List<Integer> trvIdlList = new ArrayList<>();
        trvIdlList.add(Travel.getSelectedTravel().getId());
        List<TrvReport> trvReportList = DBQuery.getTrvReportData(trvIdlList);
        generateTravelReport(trvReportList, registrationPane);
        tabPane.getTabs().add(0, registrationTab);
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        selectionModel.select(registrationTab);
        refreshRegTouristTableView(Travel.getSelectedTravel());
    }
    @FXML
    void addTravel(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TravelWindow.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.setTitle("Domestic Tourism System");
            stage.getIcons().add(new Image("/icon.png"));
            stage.showAndWait();
        }catch(Exception e){
        }
    }
    
    ///////////////===========================
    void initRegTouristTableView(){
        regTouristTable.getColumns().clear();
        
        TableColumn<RegTourist, Integer> touristColumn = new TableColumn<>("رقم السائح");
        touristColumn.setCellValueFactory(new PropertyValueFactory<>("touristId"));
        regTouristTable.getColumns().add(touristColumn);
        
        TableColumn<RegTourist, Integer> touristNameColumn = new TableColumn<>("اسم السائح");
        touristNameColumn.setCellValueFactory(new PropertyValueFactory<>("touristName"));
        regTouristTable.getColumns().add(touristNameColumn);
        
        TableColumn<RegTourist, Integer> touristNIDColumn = new TableColumn<>("الرقم القومي");
        touristNIDColumn.setCellValueFactory(new PropertyValueFactory<>("touristNID"));
        regTouristTable.getColumns().add(touristNIDColumn);

       
        TableColumn<RegTourist, Date> regDateColumn = new TableColumn<>("تاريخ الإشتراك");
        regDateColumn.setCellValueFactory(new PropertyValueFactory<>("regDate"));
        regTouristTable.getColumns().add(regDateColumn);
        
        TableColumn<RegTourist, Double> actualProfitColumn = new TableColumn<>("تكلفة الإشتراك");
        actualProfitColumn.setCellValueFactory(new PropertyValueFactory<>("actualProfit"));
        regTouristTable.getColumns().add(actualProfitColumn);
        
        TableColumn<RegTourist, Integer> travelColumn = new TableColumn<>("رقم الرحلة");
        travelColumn.setCellValueFactory(new PropertyValueFactory<>("travel"));
        regTouristTable.getColumns().add(travelColumn);
    }
   
    void refreshRegTouristTableView(Travel travel){
        // clear all items
        regTouristTable.getItems().clear();

        List<RegTourist> regTouristList = null;
        try{
            travel = DBQuery.getTravel(travel.getId());
            regTouristList = travel.getRegTourist() ;
            List<Integer> trvIdlList = new ArrayList<>();
        trvIdlList.add(travel.getId());
        List<TrvReport> trvReportList = DBQuery.getTrvReportData(trvIdlList);
        generateTravelReport(trvReportList, registrationPane);
        }catch(Exception e){
        }
        if(regTouristList != null)
            for (RegTourist reg : regTouristList)
                regTouristTable.getItems().add(reg);
        
    }
   
    void initRegPlaceTableView(){
        regPlaceTable.getColumns().clear();
        
        TableColumn<RegPlace, Integer> idColumn = new TableColumn<>("رقم المزار");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("placeId"));
        regPlaceTable.getColumns().add(idColumn);
        
        TableColumn<RegPlace, Integer> placeNameColumn = new TableColumn<>("اسم المزار");
        placeNameColumn.setCellValueFactory(new PropertyValueFactory<>("placeName"));
        regPlaceTable.getColumns().add(placeNameColumn);
       
        TableColumn<RegPlace, Date> regDateColumn = new TableColumn<>("تاريخ الإشتراك");
        regDateColumn.setCellValueFactory(new PropertyValueFactory<>("regDate"));
        regPlaceTable.getColumns().add(regDateColumn);
        
        TableColumn<RegPlace, Double> totalCostColumn = new TableColumn<>("تكلفة الإشتراك");
        totalCostColumn.setCellValueFactory(new PropertyValueFactory<>("totalCost"));
        regPlaceTable.getColumns().add(totalCostColumn);
        
        refreshRegPlaceTableView(Travel.getSelectedTravel());
        
    }

    void refreshRegPlaceTableView(Travel travel){
        // clear all items
        regPlaceTable.getItems().clear();

        List<RegPlace> regPlaceList = null;
        try{
            travel = DBQuery.getTravel(travel.getId());
            regPlaceList = travel.getRegPLace();
            List<Integer> trvIdlList = new ArrayList<>();
            trvIdlList.add(travel.getId());
            List<TrvReport> trvReportList = DBQuery.getTrvReportData(trvIdlList);
            generateTravelReport(trvReportList, registrationPane);
        }catch(Exception e){
        }
        if(regPlaceList != null)
            for (RegPlace reg : regPlaceList)
                regPlaceTable.getItems().add(reg);
        
    }

    void initRegCampaignTableView(){
        regCampaignTable.getColumns().clear();
        
        TableColumn<Campaign, Integer> idColumn = new TableColumn<>("رقم الحملة الإعلانية");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        regCampaignTable.getColumns().add(idColumn);
        
        TableColumn<Campaign, Integer> travelColumn = new TableColumn<>("رقم الرحلة");
        travelColumn.setCellValueFactory(new PropertyValueFactory<>("travel"));
        regCampaignTable.getColumns().add(travelColumn);
        
        TableColumn<Campaign, Integer> advertisementColumn = new TableColumn<>("رقم الإعلان");
        advertisementColumn.setCellValueFactory(new PropertyValueFactory<>("advertisement"));
        regCampaignTable.getColumns().add(advertisementColumn);
       
         TableColumn<Campaign, String> mediaColumn = new TableColumn<>("وسيلة الإعلان");
       mediaColumn.setCellValueFactory(new PropertyValueFactory<>("media"));
        regCampaignTable.getColumns().add(mediaColumn);
        
        TableColumn<Campaign, Integer> TargetedNumColumn = new TableColumn<>("الجمهور المستهدف");
        TargetedNumColumn.setCellValueFactory(new PropertyValueFactory<>("TargetedNum"));
        regCampaignTable.getColumns().add(TargetedNumColumn);
        
        TableColumn<Campaign, Integer> reachedNumColumn = new TableColumn<>("تم الوصول إليهم");
        reachedNumColumn.setCellValueFactory(new PropertyValueFactory<>("reachedNum"));
        regCampaignTable.getColumns().add(reachedNumColumn);
        
        TableColumn<Campaign, Date> startDateColumn = new TableColumn<>("تاريخ البداية");
        startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        regCampaignTable.getColumns().add(startDateColumn);
        
        TableColumn<Campaign, Date> endDateColumn = new TableColumn<>("تاريخ النهاية");
        endDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        regCampaignTable.getColumns().add(endDateColumn);
        
        TableColumn<Campaign, String> idleColumn = new TableColumn<>("الحالة");
       idleColumn.setCellValueFactory(new PropertyValueFactory<>("idle"));
        regCampaignTable.getColumns().add(idleColumn);
        
        TableColumn<Campaign, Date> regDateColumn = new TableColumn<>("تاريخ الإشتراك");
        regDateColumn.setCellValueFactory(new PropertyValueFactory<>("regDate"));
        regCampaignTable.getColumns().add(regDateColumn);
        
        TableColumn<Campaign, Double> costColumn = new TableColumn<>("تكلفة الإشتراك");
        costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        regCampaignTable.getColumns().add(costColumn);
        
        refreshCampaignTableView(Travel.getSelectedTravel());
        
    }

    void refreshCampaignTableView(Travel travel){
        // clear all items
        regCampaignTable.getItems().clear();

        List<Campaign> regCampaignList = null;
        try{
            travel = DBQuery.getTravel(travel.getId());
            regCampaignList = travel.getCampaign();
        }catch(Exception e){
        }
        if(regCampaignList != null)
            for (Campaign reg : regCampaignList)
                regCampaignTable.getItems().add(reg);
        
    }

    void initRegHostelTableView(){
        regHostelTable.getColumns().clear();
        
        // TableColumn<RegHostel, Integer> idColumn = new TableColumn<>("رقم محل الإقامة");
        // idColumn.setCellValueFactory(new PropertyValueFactory<>("place"));
        // regHostelTable.getColumns().add(idColumn);
        
        TableColumn<RegHostel, Integer> travelColumn = new TableColumn<>("رقم الرحلة");
        travelColumn.setCellValueFactory(new PropertyValueFactory<>("travel"));
        regHostelTable.getColumns().add(travelColumn);
       
        TableColumn<RegHostel, Integer> roomNumColumn = new TableColumn<>("عدد الغرف المحجوزة");
        roomNumColumn.setCellValueFactory(new PropertyValueFactory<>("roomNum"));
        regHostelTable.getColumns().add(roomNumColumn);
        
        TableColumn<RegHostel, Integer> nightsNumColumn = new TableColumn<>("عدد الليالي");
        nightsNumColumn.setCellValueFactory(new PropertyValueFactory<>("nightsNum"));
        regHostelTable.getColumns().add(nightsNumColumn);
        
        TableColumn<RegHostel, Date> regDateColumn = new TableColumn<>("تاريخ الإشتراك");
        regDateColumn.setCellValueFactory(new PropertyValueFactory<>("regDate"));
        regHostelTable.getColumns().add(regDateColumn);
        
        TableColumn<RegHostel, Double> totalCostColumn = new TableColumn<>("تكلفة الإشتراك");
        totalCostColumn.setCellValueFactory(new PropertyValueFactory<>("totalCost"));
        regHostelTable.getColumns().add(totalCostColumn);
        
        refreshRegHostelTableView(Travel.getSelectedTravel());
        
    }

    void refreshRegHostelTableView(Travel travel){
        // clear all items
        regHostelTable.getItems().clear();

        List<RegHostel> regHostelList = null;
        try{
            travel = DBQuery.getTravel(travel.getId());
            regHostelList = travel.getRegHostel();
        }catch(Exception e){
        }
        if(regHostelList != null)
            for (RegHostel reg : regHostelList)
                regHostelTable.getItems().add(reg);
        
    }

    void initRegGuideTableView(){
        regGuideTable.getColumns().clear();
        
        TableColumn<RegGuide, Integer> idColumn = new TableColumn<>("رقم المرشد السياحي");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("guide"));
        regGuideTable.getColumns().add(idColumn);
        
        TableColumn<RegGuide, Integer> travelColumn = new TableColumn<>("رقم الرحلة");
        travelColumn.setCellValueFactory(new PropertyValueFactory<>("travel"));
        regGuideTable.getColumns().add(travelColumn);
        
        TableColumn<RegGuide, Integer> daysNumColumn = new TableColumn<>("عدد الأيام");
        daysNumColumn.setCellValueFactory(new PropertyValueFactory<>("daysNum"));
        regGuideTable.getColumns().add(daysNumColumn);
        
        TableColumn<RegGuide, Date> regDateColumn = new TableColumn<>("تاريخ الإشتراك");
        regDateColumn.setCellValueFactory(new PropertyValueFactory<>("regDate"));
        regGuideTable.getColumns().add(regDateColumn);
        
        TableColumn<RegGuide, Double> totalCostColumn = new TableColumn<>("تكلفة الإشتراك");
        totalCostColumn.setCellValueFactory(new PropertyValueFactory<>("totalCost"));
        regGuideTable.getColumns().add(totalCostColumn);
        
        
        refreshRegGuideTableView(Travel.getSelectedTravel());
    }

    void refreshRegGuideTableView(Travel travel){
        // clear all items
        regGuideTable.getItems().clear();

        List<RegGuide> regGuideList = null;
        try{
            travel = DBQuery.getTravel(travel.getId());
            regGuideList = travel.getRegGuide();
        }catch(Exception e){
        }
        if(regGuideList != null)
            for (RegGuide reg : regGuideList)
                regGuideTable.getItems().add(reg);
        
    }

    void initRegTransportTableView(){
        regTransportTable.getColumns().clear();
        
        TableColumn<RegTransport, Integer> idColumn = new TableColumn<>("رقم وسيلة النقل");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("transportId"));
        regTransportTable.getColumns().add(idColumn);
        
        TableColumn<RegTransport, String> typeColumn = new TableColumn<>("النوع");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("transportType"));
        regTransportTable.getColumns().add(typeColumn);
        
        TableColumn<RegTransport, String> panelNoColumn = new TableColumn<>("رقم اللوحة");
        panelNoColumn.setCellValueFactory(new PropertyValueFactory<>("transportPanelNo"));
        regTransportTable.getColumns().add(panelNoColumn);
        
        TableColumn<RegTransport, String> modelColumn = new TableColumn<>("الموديل");
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("transportModel"));
        regTransportTable.getColumns().add(modelColumn);
        
        TableColumn<RegTransport, Integer> capacityColumn = new TableColumn<>("السعة");
        capacityColumn.setCellValueFactory(new PropertyValueFactory<>("transportCapacity"));
        regTransportTable.getColumns().add(capacityColumn);
        
        TableColumn<RegTransport, String> cityColumn = new TableColumn<>("المدينة");
        cityColumn.setCellValueFactory(new PropertyValueFactory<>("transportCity"));
        regTransportTable.getColumns().add(cityColumn);
       
        TableColumn<RegTransport, Integer> daysNumColumn = new TableColumn<>("عدد الأيام");
        daysNumColumn.setCellValueFactory(new PropertyValueFactory<>("daysNum"));
        regTransportTable.getColumns().add(daysNumColumn);
        
        TableColumn<RegTransport, Date> regDateColumn = new TableColumn<>("تاريخ الإشتراك");
        regDateColumn.setCellValueFactory(new PropertyValueFactory<>("regDate"));
        regTransportTable.getColumns().add(regDateColumn);
        
        TableColumn<RegTransport, Double> totalCostColumn = new TableColumn<>("تكلفة الإشتراك");
        totalCostColumn.setCellValueFactory(new PropertyValueFactory<>("totalCost"));
        regTransportTable.getColumns().add(totalCostColumn);
        
        
        TableColumn<RegTransport, String> transportServiceColumn = new TableColumn<>("خدمة النقل");
        transportServiceColumn.setCellValueFactory(new PropertyValueFactory<>("transportService"));
        regTransportTable.getColumns().add(transportServiceColumn);
        
        refreshRegTransportTableView(Travel.getSelectedTravel());
        
    }
    
    void refreshRegTransportTableView(Travel travel){
        // clear all items
        regTransportTable.getItems().clear();

        List<RegTransport> regTransportList = null;
        try{
            travel = DBQuery.getTravel(travel.getId());
            regTransportList = travel.getRegTransport();
        }catch(Exception e){
        }
        if(regTransportList != null)
            for (RegTransport reg : regTransportList)
                regTransportTable.getItems().add(reg);
        
    }

    // ------------- Internal Methods ------------- //

    void initAgentTableView(){
        agentTable.getColumns().clear();
        
        TableColumn<Agent, Integer> idColumn = new TableColumn<>("الرقم");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        agentTable.getColumns().add(idColumn);
        
        TableColumn<Agent, String> nameColumn = new TableColumn<>("الاسم");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        agentTable.getColumns().add(nameColumn);
        
        TableColumn<Agent, String> nidColumn = new TableColumn<>("الرقم القومي");
        nidColumn.setCellValueFactory(new PropertyValueFactory<>("nid"));
        agentTable.getColumns().add(nidColumn);
        
        TableColumn<Agent, String> genderColumn = new TableColumn<>("النوع");
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        agentTable.getColumns().add(genderColumn);
        
        TableColumn<Agent, String> mobileColumn = new TableColumn<>("الهاتف");
        mobileColumn.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        agentTable.getColumns().add(mobileColumn);
        
        TableColumn<Agent, Date> birthDateColumn = new TableColumn<>("تاريخ الميلاد");
        birthDateColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        agentTable.getColumns().add(birthDateColumn);
        
        TableColumn<Agent, String> emailColumn = new TableColumn<>("الإيميل");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        agentTable.getColumns().add(emailColumn);
        
        TableColumn<Agent, String> cityIDColumn = new TableColumn<>("المدينة");
        cityIDColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        agentTable.getColumns().add(cityIDColumn);
        
        TableColumn<Agent, String> localAddressColumn = new TableColumn<>("العنوان");
        localAddressColumn.setCellValueFactory(new PropertyValueFactory<>("localAddress"));
        agentTable.getColumns().add(localAddressColumn);
        
        TableColumn<Agent, Date> createdDateColumn = new TableColumn<>("تاريخ الإنشاء");
        createdDateColumn.setCellValueFactory(new PropertyValueFactory<>("createDate"));
        agentTable.getColumns().add(createdDateColumn);
        
        TableColumn<Agent, String> idleColumn = new TableColumn<>("الحالة");
        idleColumn.setCellValueFactory(new PropertyValueFactory<>("idle"));
        agentTable.getColumns().add(idleColumn);
      
        refreshAgentTableView();
    }

    void refreshAgentTableView(){
        // clear all items
        agentTable.getItems().clear();

        List<Agent> angetList = null;
        try{
            angetList = DBQuery.getResAgent(DBQuery.getData("Agent"));
        }catch(Exception e){
        }
        if(angetList != null)
            for (Agent agent : angetList)
                agentTable.getItems().add(agent);
        
    }
    
    void initTransportTableView(){
        transportTable.getColumns().clear();
        
        TableColumn<Transport, Integer> idColumn = new TableColumn<>("الرقم");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        transportTable.getColumns().add(idColumn);
        
        TableColumn<Transport, String> typeColumn = new TableColumn<>("النوع");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        transportTable.getColumns().add(typeColumn);
        
        TableColumn<Transport, String> transportServiceColumn = new TableColumn<>("خدمة النقل");
        transportServiceColumn.setCellValueFactory(new PropertyValueFactory<>("transportService"));
        transportTable.getColumns().add(transportServiceColumn);
        
        TableColumn<Transport, String> panelNoColumn = new TableColumn<>("رقم اللوحة");
        panelNoColumn.setCellValueFactory(new PropertyValueFactory<>("panelNo"));
        transportTable.getColumns().add(panelNoColumn);
        
        TableColumn<Transport, String> modelColumn = new TableColumn<>("الموديل");
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        transportTable.getColumns().add(modelColumn);
        
        TableColumn<Transport, Integer> capacityColumn = new TableColumn<>("السعة");
        capacityColumn.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        transportTable.getColumns().add(capacityColumn);
        
        TableColumn<Transport, String> cityIDColumn = new TableColumn<>("المدينة");
        cityIDColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        transportTable.getColumns().add(cityIDColumn);
        
        TableColumn<Transport, Date> creatdDateColumn = new TableColumn<>("تاريخ الإنشاء");
        creatdDateColumn.setCellValueFactory(new PropertyValueFactory<>("creatDate"));
        transportTable.getColumns().add(creatdDateColumn);
        
        TableColumn<Transport, Double> costColumn = new TableColumn<>("السعر");
        costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        transportTable.getColumns().add(costColumn);
        
        TableColumn<Transport, String> idleColumn = new TableColumn<>("الحالة");
        idleColumn.setCellValueFactory(new PropertyValueFactory<>("idle"));
        transportTable.getColumns().add(idleColumn);
      
        refreshTransportTableView();
    }

    void refreshTransportTableView(){
        // clear all items
        transportTable.getItems().clear();
        List<Transport> transportList = null;
        try{
            transportList = DBQuery.getResTransport(DBQuery.getData("Transport"));
        }catch(Exception e){
        }
        if(transportList != null)
            for (Transport transport : transportList)
                transportTable.getItems().add(transport);
        
    }

    void initTouristTableView(){
        touristTable.getColumns().clear();
        
        TableColumn<Tourist, Integer> idColumn = new TableColumn<>("الرقم");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        touristTable.getColumns().add(idColumn);
        
        TableColumn<Tourist, Integer> prtColumn = new TableColumn<>("الشريك");
        prtColumn.setCellValueFactory(new PropertyValueFactory<>("partner"));
        touristTable.getColumns().add(prtColumn);
       
        TableColumn<Tourist, String> infoColumn = new TableColumn<>("معلومات إضافية");
        infoColumn.setCellValueFactory(new PropertyValueFactory<>("info"));
        touristTable.getColumns().add(infoColumn);
        
        TableColumn<Tourist, Double> balanceColumn = new TableColumn<>("الرصيد");
        balanceColumn.setCellValueFactory(new PropertyValueFactory<>("balance"));
        touristTable.getColumns().add(balanceColumn);
        
        TableColumn<Tourist, String> nameColumn = new TableColumn<>("الاسم");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        touristTable.getColumns().add(nameColumn);
        
        TableColumn<Tourist, String> nidColumn = new TableColumn<>("الرقم القومي");
        nidColumn.setCellValueFactory(new PropertyValueFactory<>("nid"));
        touristTable.getColumns().add(nidColumn);
        
        TableColumn<Tourist, String> genderColumn = new TableColumn<>("النوع");
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        touristTable.getColumns().add(genderColumn);
        
        TableColumn<Tourist, String> mobileColumn = new TableColumn<>("الهاتف");
        mobileColumn.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        touristTable.getColumns().add(mobileColumn);
        
        TableColumn<Tourist, Date> birthDateColumn = new TableColumn<>("تاريخ الميلاد");
        birthDateColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        touristTable.getColumns().add(birthDateColumn);
        
        TableColumn<Tourist, String> emailColumn = new TableColumn<>("الإيميل");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        touristTable.getColumns().add(emailColumn);
        
        TableColumn<Tourist, String> cityIDColumn = new TableColumn<>("المحافظة");
        cityIDColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        touristTable.getColumns().add(cityIDColumn);
        
        TableColumn<Tourist, String> localAddressColumn = new TableColumn<>("العنوان");
        localAddressColumn.setCellValueFactory(new PropertyValueFactory<>("localAddress"));
        touristTable.getColumns().add(localAddressColumn);
        
        TableColumn<Tourist, Date> createdDateColumn = new TableColumn<>("تاريخ الإنشاء");
        createdDateColumn.setCellValueFactory(new PropertyValueFactory<>("createDate"));
        touristTable.getColumns().add(createdDateColumn);
        
        TableColumn<Tourist, String> idleColumn = new TableColumn<>("الحالة");
        idleColumn.setCellValueFactory(new PropertyValueFactory<>("idle"));
        touristTable.getColumns().add(idleColumn);
        
        refreshTouristTableView();
    }

    void refreshTouristTableView(){
        // clear all items
        touristTable.getItems().clear();

        List<Tourist> list = null;
        try{
            list = DBQuery.getResTourist(DBQuery.getData("Tourist"));
            if(list != null)
                for (Tourist t : list)
                    touristTable.getItems().add(t);
        }catch(Exception e){
        }
    }

    void initAdServiceTableView(){
        adServiceTable.getColumns().clear();
        
        TableColumn<AdService, Integer> idColumn = new TableColumn<>("الرقم");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        adServiceTable.getColumns().add(idColumn);
        
        TableColumn<AdService, String> nameColumn = new TableColumn<>("الاسم");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        adServiceTable.getColumns().add(nameColumn);
        
        TableColumn<AdService, String> nidColumn = new TableColumn<>("رقم التسجيل");
        nidColumn.setCellValueFactory(new PropertyValueFactory<>("crn"));
        adServiceTable.getColumns().add(nidColumn);
         
        TableColumn<AdService, String> emailColumn = new TableColumn<>("الإيميل");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        adServiceTable.getColumns().add(emailColumn);
        
        TableColumn<AdService, String> phonesColumn = new TableColumn<>("هاتف");
        phonesColumn.setCellValueFactory(new PropertyValueFactory<>("phones"));
        adServiceTable.getColumns().add(phonesColumn);

        TableColumn<AdService, String> cityIDColumn = new TableColumn<>("المدينة");
        cityIDColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        adServiceTable.getColumns().add(cityIDColumn);
        
        TableColumn<AdService, String> localAddressColumn = new TableColumn<>("العنوان");
        localAddressColumn.setCellValueFactory(new PropertyValueFactory<>("localAddress"));
        adServiceTable.getColumns().add(localAddressColumn);
        
        TableColumn<AdService, String> typeColumn = new TableColumn<>("النوع");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        adServiceTable.getColumns().add(typeColumn);

        TableColumn<AdService, Date> createdDateColumn = new TableColumn<>("تاريخ الإنشاء");
        createdDateColumn.setCellValueFactory(new PropertyValueFactory<>("createDate"));
        adServiceTable.getColumns().add(createdDateColumn);
        
        TableColumn<AdService, String> idleColumn = new TableColumn<>("الحالة");
        idleColumn.setCellValueFactory(new PropertyValueFactory<>("idle"));
        adServiceTable.getColumns().add(idleColumn);
        
        refreshAdServiceTableView();
    }

    void refreshAdServiceTableView(){
        // clear all items
        adServiceTable.getItems().clear();

        List<AdService> list = null;
        try{
            list = DBQuery.getResAdService(DBQuery.getSelectiveData("ServiceProvider","class","ad"));
        }catch(Exception e){
        }
        // if(adServiceTable != null)
        if(list != null)
            for (AdService t : list)
                adServiceTable.getItems().add(t);
    }

    void initHostelServiceTableView(){
        hostelServiceTable.getColumns().clear();
        
        TableColumn<HostelService, Integer> idColumn = new TableColumn<>("الرقم");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        hostelServiceTable.getColumns().add(idColumn);
        
        TableColumn<HostelService, String> nameColumn = new TableColumn<>("الاسم");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        hostelServiceTable.getColumns().add(nameColumn);
        
        TableColumn<HostelService, String> nidColumn = new TableColumn<>("رقم التسجيل");
        nidColumn.setCellValueFactory(new PropertyValueFactory<>("crn"));
        hostelServiceTable.getColumns().add(nidColumn);
         
        TableColumn<HostelService, String> emailColumn = new TableColumn<>("الإيميل");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        hostelServiceTable.getColumns().add(emailColumn);
                
        TableColumn<HostelService, String> phonesColumn = new TableColumn<>("هاتف");
        phonesColumn.setCellValueFactory(new PropertyValueFactory<>("phones"));
        hostelServiceTable.getColumns().add(phonesColumn);
        
        TableColumn<HostelService, String> cityIDColumn = new TableColumn<>("المدينة");
        cityIDColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        hostelServiceTable.getColumns().add(cityIDColumn);
        
        TableColumn<HostelService, String> localAddressColumn = new TableColumn<>("العنوان");
        localAddressColumn.setCellValueFactory(new PropertyValueFactory<>("localAddress"));
        hostelServiceTable.getColumns().add(localAddressColumn);
        
        TableColumn<HostelService, String> typeColumn = new TableColumn<>("النوع");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        hostelServiceTable.getColumns().add(typeColumn);

        TableColumn<HostelService, Date> createdDateColumn = new TableColumn<>("تاريخ الإنشاء");
        createdDateColumn.setCellValueFactory(new PropertyValueFactory<>("createDate"));
        hostelServiceTable.getColumns().add(createdDateColumn);
        
        TableColumn<HostelService, String> idleColumn = new TableColumn<>("الحالة");
        idleColumn.setCellValueFactory(new PropertyValueFactory<>("idle"));
        hostelServiceTable.getColumns().add(idleColumn);
        
        refreshHostelServiceTableView();
    }

    void refreshHostelServiceTableView(){
        // clear all items
        hostelServiceTable.getItems().clear();

        List<HostelService> list = null;
        try{
            list = DBQuery.getResHostelService(DBQuery.getSelectiveData("ServiceProvider","class","hst"));
        }catch(Exception e){
        }
        // if(hostelServiceTable != null)
        if(list != null)
            for (HostelService t : list)
                hostelServiceTable.getItems().add(t);
    }

    void initTransportServiceTableView(){
        transportServiceTable.getColumns().clear();
        
        TableColumn<TransportService, Integer> idColumn = new TableColumn<>("الرقم");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        transportServiceTable.getColumns().add(idColumn);
        
        TableColumn<TransportService, String> nameColumn = new TableColumn<>("الاسم");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        transportServiceTable.getColumns().add(nameColumn);
        
        TableColumn<TransportService, String> nidColumn = new TableColumn<>("رقم التسجيل");
        nidColumn.setCellValueFactory(new PropertyValueFactory<>("crn"));
        transportServiceTable.getColumns().add(nidColumn);
         
        TableColumn<TransportService, String> emailColumn = new TableColumn<>("الإيميل");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        transportServiceTable.getColumns().add(emailColumn);
        
        TableColumn<TransportService, String> phonesColumn = new TableColumn<>("هاتف");
        phonesColumn.setCellValueFactory(new PropertyValueFactory<>("phones"));
        transportServiceTable.getColumns().add(phonesColumn);

        TableColumn<TransportService, String> cityIDColumn = new TableColumn<>("المدينة");
        cityIDColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        transportServiceTable.getColumns().add(cityIDColumn);
        
        TableColumn<TransportService, String> localAddressColumn = new TableColumn<>("العنوان");
        localAddressColumn.setCellValueFactory(new PropertyValueFactory<>("localAddress"));
        transportServiceTable.getColumns().add(localAddressColumn);
        
        TableColumn<TransportService, String> typeColumn = new TableColumn<>("النوع");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        transportServiceTable.getColumns().add(typeColumn);

        TableColumn<TransportService, Date> createdDateColumn = new TableColumn<>("تاريخ الإنشاء");
        createdDateColumn.setCellValueFactory(new PropertyValueFactory<>("createDate"));
        transportServiceTable.getColumns().add(createdDateColumn);
        
        TableColumn<TransportService, String> idleColumn = new TableColumn<>("الحالة");
        idleColumn.setCellValueFactory(new PropertyValueFactory<>("idle"));
        transportServiceTable.getColumns().add(idleColumn);
        
        refreshTransportServiceTableView();
    }

    void refreshTransportServiceTableView(){
        // clear all items
        transportServiceTable.getItems().clear();

        List<TransportService> list = null;
        try{
            list = DBQuery.getResTransportService(DBQuery.getSelectiveData("ServiceProvider","class","trs"));
        }catch(Exception e){
        }
        // if(transportServiceTable != null)
        if(list != null)
            for (TransportService t : list)
                transportServiceTable.getItems().add(t);
    }

    void initPartnerTableView(){
        partnerTable.getColumns().clear();
        
        TableColumn<Partner, Integer> idColumn = new TableColumn<>("الرقم");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        partnerTable.getColumns().add(idColumn);
        
        TableColumn<Partner, String> nameColumn = new TableColumn<>("الاسم");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        partnerTable.getColumns().add(nameColumn);
        
        TableColumn<Partner, String> nidColumn = new TableColumn<>("رقم التسجيل");
        nidColumn.setCellValueFactory(new PropertyValueFactory<>("crn"));
        partnerTable.getColumns().add(nidColumn);
         
        TableColumn<Partner, String> emailColumn = new TableColumn<>("الإيميل");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        partnerTable.getColumns().add(emailColumn);
        
        TableColumn<Partner, String> cityIDColumn = new TableColumn<>("المدينة");
        cityIDColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        partnerTable.getColumns().add(cityIDColumn);
        
        TableColumn<Partner, String> localAddressColumn = new TableColumn<>("العنوان");
        localAddressColumn.setCellValueFactory(new PropertyValueFactory<>("localAddress"));
        partnerTable.getColumns().add(localAddressColumn);
        
        TableColumn<Partner, String> typeColumn = new TableColumn<>("النوع");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        partnerTable.getColumns().add(typeColumn);
        
        TableColumn<Partner, Double> discountColumn = new TableColumn<>("نسبة الخصم");
        discountColumn.setCellValueFactory(new PropertyValueFactory<>("discount"));
        partnerTable.getColumns().add(discountColumn);
       
        TableColumn<Partner, Date> createdDateColumn = new TableColumn<>("تاريخ الإنشاء");
        createdDateColumn.setCellValueFactory(new PropertyValueFactory<>("createDate"));
        partnerTable.getColumns().add(createdDateColumn);
        
        TableColumn<Partner, String> idleColumn = new TableColumn<>("الحالة");
        idleColumn.setCellValueFactory(new PropertyValueFactory<>("idle"));
        partnerTable.getColumns().add(idleColumn);
        
        refreshPartnerTableView();
    }

    void refreshPartnerTableView(){
        // clear all items
        partnerTable.getItems().clear();

        List<Partner> list = null;
        try{
            list = DBQuery.getResPartner(DBQuery.getSelectiveData("ServiceProvider","class","prt"));
        }catch(Exception e){
        }
        if(list != null)
            for (Partner t : list)
                partnerTable.getItems().add(t);
    }

    void initGuideTableView(){
        guideTable.getColumns().clear();
        
        TableColumn<Guide, Integer> idColumn = new TableColumn<>("الرقم");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        guideTable.getColumns().add(idColumn);
    
        TableColumn<Guide, Integer> specialtyColumn = new TableColumn<>("التخصص");
        specialtyColumn.setCellValueFactory(new PropertyValueFactory<>("specialty"));
        guideTable.getColumns().add(specialtyColumn);
        
        TableColumn<Guide, String> nameColumn = new TableColumn<>("الاسم");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        guideTable.getColumns().add(nameColumn);
        
        TableColumn<Guide, String> nidColumn = new TableColumn<>("الرقم القومي");
        nidColumn.setCellValueFactory(new PropertyValueFactory<>("nid"));
        guideTable.getColumns().add(nidColumn);
        
        TableColumn<Guide, String> genderColumn = new TableColumn<>("النوع");
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        guideTable.getColumns().add(genderColumn);
        
        TableColumn<Guide, String> mobileColumn = new TableColumn<>("موبايل");
        mobileColumn.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        guideTable.getColumns().add(mobileColumn);
        
        TableColumn<Guide, Date> birthDateColumn = new TableColumn<>("تاريخ الميلاد");
        birthDateColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        guideTable.getColumns().add(birthDateColumn);
        
        TableColumn<Guide, String> emailColumn = new TableColumn<>("الإيميل");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        guideTable.getColumns().add(emailColumn);
        
        TableColumn<Guide, String> cityIDColumn = new TableColumn<>("المدينة");
        cityIDColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        guideTable.getColumns().add(cityIDColumn);
        
        TableColumn<Guide, String> localAddressColumn = new TableColumn<>("العنوان");
        localAddressColumn.setCellValueFactory(new PropertyValueFactory<>("localAddress"));
        guideTable.getColumns().add(localAddressColumn);
        
        TableColumn<Guide, Double> rateColumn = new TableColumn<>("المكافأة");
        rateColumn.setCellValueFactory(new PropertyValueFactory<>("rate"));
        guideTable.getColumns().add(rateColumn);
        
        TableColumn<Guide, Date> createdDateColumn = new TableColumn<>("تاريخ التسجيل");
        createdDateColumn.setCellValueFactory(new PropertyValueFactory<>("createDate"));
        guideTable.getColumns().add(createdDateColumn);
        
        TableColumn<Guide, String> idleColumn = new TableColumn<>("الحالة");
        idleColumn.setCellValueFactory(new PropertyValueFactory<>("idle"));
        guideTable.getColumns().add(idleColumn);
        
        refreshGuideTableView();
    }

    void refreshGuideTableView(){
        // clear all items
        guideTable.getItems().clear();

        List<Guide> list = null;
        try{
            list = DBQuery.getGuideData();
        }catch(Exception e){
        }
        if(list != null)
            for (Guide g : list)
                guideTable.getItems().add(g);
    }
    
    /////////////////////////////////////////////////////
    void initHostelTableView(){
        hostelTable.getColumns().clear();
        
        TableColumn<Hostel, Integer> idColumn = new TableColumn<>("الرقم");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        hostelTable.getColumns().add(idColumn);
        
        TableColumn<Hostel, String> nameColumn = new TableColumn<>("الاسم");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        hostelTable.getColumns().add(nameColumn);
        
        TableColumn<Hostel, String> typeColumn = new TableColumn<>("النوع");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        hostelTable.getColumns().add(typeColumn);
        
        TableColumn<Hostel, String> hostelServiceColumn = new TableColumn<>("خدمة الإقامة");
        hostelServiceColumn.setCellValueFactory(new PropertyValueFactory<>("hostelService"));
        hostelTable.getColumns().add(hostelServiceColumn);
        
        TableColumn<Hostel, String> cityIDColumn = new TableColumn<>("المدينة");
        cityIDColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        hostelTable.getColumns().add(cityIDColumn);
        
        TableColumn<Hostel, String> localAddressColumn = new TableColumn<>("العنوان");
        localAddressColumn.setCellValueFactory(new PropertyValueFactory<>("localAdd"));
        hostelTable.getColumns().add(localAddressColumn);
        
        TableColumn<Hostel, Integer> capacityColumn = new TableColumn<>("السعة");
        capacityColumn.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        hostelTable.getColumns().add(capacityColumn);
        
        TableColumn<Hostel, Integer> hotelDegreeColumn = new TableColumn<>("الدرجة الفندقية");
        hotelDegreeColumn.setCellValueFactory(new PropertyValueFactory<>("hotelDegree"));
        hostelTable.getColumns().add(hotelDegreeColumn);
        
        TableColumn<Hostel, Double> costColumn = new TableColumn<>("السعر");
        costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        hostelTable.getColumns().add(costColumn);
        
        
        TableColumn<Hostel, Date> creatdDateColumn = new TableColumn<>("تاريخ الإنشاء");
        creatdDateColumn.setCellValueFactory(new PropertyValueFactory<>("creatDate"));
        hostelTable.getColumns().add(creatdDateColumn);
        
        TableColumn<Hostel, String> idleColumn = new TableColumn<>("الحالة");
        idleColumn.setCellValueFactory(new PropertyValueFactory<>("idle"));
        hostelTable.getColumns().add(idleColumn);
        
        refreshHostelTableView();
        
    }

    void refreshHostelTableView(){
        // clear all items
        
        hostelTable.getItems().clear();

        List<Hostel> list = null;
        
        try{
            list = DBQuery.getResHostel(DBQuery.getData("Hostel"));
            
        }catch(Exception e){
        }
        if(list != null)
            for (Hostel h : list)
                hostelTable.getItems().add(h);
    }
    
    void initAdvertisementTableView(){
        
        adTable.getColumns().clear();
        
        TableColumn<Advertisement, Integer> idColumn = new TableColumn<>("الرقم");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        adTable.getColumns().add(idColumn);
        
        TableColumn<Advertisement, String> adServiceColumn = new TableColumn<>("خدمة الدعاية");
        adServiceColumn.setCellValueFactory(new PropertyValueFactory<>("adService"));
        adTable.getColumns().add(adServiceColumn);
        
        TableColumn<Advertisement, String> infoColumn = new TableColumn<>("معلومات الإعلان");
        infoColumn.setCellValueFactory(new PropertyValueFactory<>("info"));
        adTable.getColumns().add(infoColumn);
        
        TableColumn<Advertisement, Double> costColumn = new TableColumn<>("تكلفة تصميم الإعلان");
        costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        adTable.getColumns().add(costColumn);
 
        TableColumn<Advertisement, Date> creatDateColumn = new TableColumn<>("تاريخ الإنشاء");
        creatDateColumn.setCellValueFactory(new PropertyValueFactory<>("creatDate"));
        adTable.getColumns().add(creatDateColumn);
        
        TableColumn<Advertisement, String> idleColumn = new TableColumn<>("الحالة");
        idleColumn.setCellValueFactory(new PropertyValueFactory<>("idle"));
        adTable.getColumns().add(idleColumn);
        
        refreshAdvertisementTableView();
        
    }

    void refreshAdvertisementTableView(){
        // clear all items
        adTable.getItems().clear();

        List<Advertisement> list = null;
        
        try{
            list = DBQuery.getResAdvertisement(DBQuery.getData("Advertisement"));
        }catch(Exception e){
        }
        if(list != null)
            for (Advertisement a : list)
                adTable.getItems().add(a);
    }

    void initPlaceTableView(){
        placeTable.getColumns().clear();
        
        TableColumn<Place, Integer> idColumn = new TableColumn<>("الرقم");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        placeTable.getColumns().add(idColumn);
    
        TableColumn<Place, String> typeColumn = new TableColumn<>("النوع");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        placeTable.getColumns().add(typeColumn);
        
        TableColumn<Place, String> nameColumn = new TableColumn<>("الاسم");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        placeTable.getColumns().add(nameColumn);
        
        TableColumn<Place, Integer> capacityColumn = new TableColumn<>("السعة");
        capacityColumn.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        placeTable.getColumns().add(capacityColumn);
        
        TableColumn<Place, String> cityIDColumn = new TableColumn<>("المدينة");
        cityIDColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        placeTable.getColumns().add(cityIDColumn);
        
        TableColumn<Place, Double> rateColumn = new TableColumn<>("سعر التذكرة");
        rateColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        placeTable.getColumns().add(rateColumn);
        
        TableColumn<Place, Date> createdDateColumn = new TableColumn<>("تاريخ الإنشاء");
        createdDateColumn.setCellValueFactory(new PropertyValueFactory<>("createDate"));
        placeTable.getColumns().add(createdDateColumn);
        
        TableColumn<Place, String> idleColumn = new TableColumn<>("الحالة");
        idleColumn.setCellValueFactory(new PropertyValueFactory<>("idle"));
        placeTable.getColumns().add(idleColumn);
        
        refreshPlaceTableView();
    }

    void refreshPlaceTableView(){
        // clear all items
        placeTable.getItems().clear();

        List<Place> list = null;
        try{
            list = DBQuery.getResPlace(DBQuery.getData("Place"));
        }catch(Exception e){
        }
        if(list != null)
            for (Place p : list)
                placeTable.getItems().add(p);
    }
    /////////////////////////////////////////////////////

    void initTravelTableView(){
        travelTable.getColumns().clear();
        
        TableColumn<Travel, Integer> idColumn = new TableColumn<>("الرقم");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        travelTable.getColumns().add(idColumn);
        
        TableColumn<Travel, String> titleColumn = new TableColumn<>("عنوان الرحلة");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        travelTable.getColumns().add(titleColumn);
        
        TableColumn<Travel, Date> createDateColumn = new TableColumn<>("تاريخ الإنشاء");
        createDateColumn.setCellValueFactory(new PropertyValueFactory<>("creatDate"));
        travelTable.getColumns().add(createDateColumn);
        
        TableColumn<Travel, Boolean> idleColumn = new TableColumn<>("الحالة");
        idleColumn.setCellValueFactory(new PropertyValueFactory<>("idle"));
        travelTable.getColumns().add(idleColumn);
        
        TableColumn<Travel, Date> startDateColumn = new TableColumn<>("تاريخ البداية");
        startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        travelTable.getColumns().add(startDateColumn);
        
        TableColumn<Travel, Date> endDateColumn = new TableColumn<>("تاريخ النهاية");
        endDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        travelTable.getColumns().add(endDateColumn);
        
        TableColumn<Travel, Double> priceColumn = new TableColumn<>("السعر");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        travelTable.getColumns().add(priceColumn);

        refreshTravelTableView();
    }
    
    void refreshTravelTableView(){
        travelTable.getItems().clear();

        List<Travel> list = null;
        try {
            list = DBQuery.getResTravel(DBQuery.getData("Travel"));
            if(list != null)
                for(Travel t : list)
                    travelTable.getItems().add(t);
        } catch (Exception e) {
        }
        
    }
    
    void initScheduleTableView(){
        scheduleTable.getColumns().clear();
        
        TableColumn<Schedule, Date> dateColumn = new TableColumn<>("تاريخ الرحلة");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        scheduleTable.getColumns().add(dateColumn);
        
        TableColumn<Schedule, Integer> idColumn = new TableColumn<>("الرقم");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        scheduleTable.getColumns().add(idColumn);
        
        TableColumn<Schedule, String> titleColumn = new TableColumn<>("عنوان الرحلة");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        scheduleTable.getColumns().add(titleColumn);

        refreshScheduleTableView();
    }
    
    void refreshScheduleTableView(){
        scheduleTable.getItems().clear();

        List<Schedule> list = null;
        try {
            list = DBQuery.getScheduleData();
            if(list != null)
                for(Schedule s : list)
                    scheduleTable.getItems().add(s);
        } catch (Exception e) {
        }

    }
    
    @FXML
    private void close(ActionEvent event) {
    Stage stage = (Stage) borderPane.getScene().getWindow();
    stage.close();
    }

    @FXML
    private void showTravelMenu(ActionEvent event) {
        initTravelTableView();
        tabPane.getTabs().add(0, travelTab);
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        selectionModel.select(travelTab);
        try {
            List<String> columnsList = DBQuery.getElementColumns("Travel");
            for (String c : columnsList)
                travelSearchComboBox.getItems().add(toArEn(c));
           travelSearchComboBox.getSelectionModel().select(4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showTouristlMenu(ActionEvent event) {
       initTouristTableView();
       tabPane.getTabs().add(0, touristTab);
       SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
       selectionModel.select(touristTab);
       touristSearchComboBox.getItems().clear();
       try {
            List<String> columnsList = DBQuery.getElementColumns("Tourist");
            for (String c : columnsList)
                touristSearchComboBox.getItems().add(toArEn(c));
            touristSearchComboBox.getSelectionModel().select(4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showPlaceMenu(ActionEvent event) {
        initPlaceTableView();
        tabPane.getTabs().add(0, placeTab);
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        selectionModel.select(placeTab);
        placeSearchComboBox.getItems().clear();
        try {
            List<String> columnsList = DBQuery.getElementColumns("Place");
            for (String c : columnsList)
                placeSearchComboBox.getItems().add(toArEn(c));
            placeSearchComboBox.getSelectionModel().select(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private String toArEn(String columnName){
      
       HashMap<String,String> Ar = new HashMap<String,String>();
       HashMap<String,String> En = new HashMap<String,String>();
       Ar.put("الرقم", "id");                      En.put("id", "الرقم");
       Ar.put("الشريك", "prtID");                  En.put("prtID","الشريك" );
       Ar.put("معلومات إضافية", "info");           En.put("info", "معلومات إضافية");
       Ar.put("الرصيد", "price");                  En.put("price","الرصيد" );
       Ar.put("الاسم", "name");                     En.put("name","الاسم" );
       Ar.put("الرقم القومي", "NID");              En.put("NID","الرقم القومي" );
       Ar.put("النوع", "gender");                  En.put("gender", "النوع");
       Ar.put("الهاتف", "mobile");                 En.put("mobile", "الهاتف");
       Ar.put("تاريخ الميلاد", "birthDate");        En.put("birthDate", "تاريخ الميلاد");
       Ar.put("الإيميل", "email");                  En.put("email", "الإيميل");
       Ar.put("المدينة", "cityID");                En.put("cityID", "المدينة");
       Ar.put("العنوان", "localAdd");              En.put("localAdd", "العنوان");
       Ar.put("تاريخ الإنشاء", "creatDate");        En.put("creatDate", "تاريخ الإنشاء");
       Ar.put("الحالة", "idle");                   En.put("idle", "الحالة");
       Ar.put("التخصص", "specialty");              En.put("specialty", "التخصص");
       Ar.put("المكافأة", "rate");                 En.put("rate", "المكافأة");
       Ar.put("اسم المستخدم", "usrID");            En.put("usrID", "اسم المستخدم");
       Ar.put("كلمة المرور", "password");          En.put("password", "كلمة المرور");
       Ar.put("عنوان الرحلة", "title");            En.put("title", "عنوان الرحلة");
       Ar.put("السعر", "price");                   En.put("price", "السعر");
       Ar.put("تاريخ البداية", "startDate");       En.put("startDate", "تاريخ البداية");
       Ar.put("تاريخ النهاية", "endDate");         En.put("endDate", "تاريخ النهاية");
       Ar.put("رقم التسجيل", "crn");               En.put("crn", "رقم التسجيل");
       Ar.put("السعة", "capacity");                En.put("capacity", "السعة");
       Ar.put("سعر التذكرة", "cost");              En.put("cost", "سعر التذكرة");
       Ar.put("مالك النزل", "hstOwner");           En.put("hstOwner", "مالك النزل");
       Ar.put("مالك وسيلة النقل", "trsOwner");     En.put("trsOwner", "مالك وسيلة النقل");
       Ar.put("شركة الدعاية", "adCompany");        En.put("adCompany", "شركة الدعاية");
       Ar.put("النوع ", "type");                   En.put("type", "النوع ");
       Ar.put("الرصيد", "balance");                En.put("balance", "الرصيد");
      // Ar.put("", );
      // En.put("", );

       if(En.containsValue(columnName)){
           columnName = Ar.get(columnName);
           return columnName;
       }
       if(Ar.containsValue(columnName))
           columnName = En.get(columnName);
           return columnName;
    }

    @FXML
    private void showHostelMenu(ActionEvent event) {
        initHostelTableView();
        tabPane.getTabs().add(0, hostelTab);
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        selectionModel.select(hostelTab);
        hostelSearchComboBox.getItems().clear();
        try {
            //agentSearchComboBox.getItems().add("");
            List<String> columnsList = DBQuery.getElementColumns("Hostel");
            for (String c : columnsList)
                hostelSearchComboBox.getItems().add(toArEn(c));
            hostelSearchComboBox.getSelectionModel().select(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showPartnerMenu(ActionEvent event) {
        initPartnerTableView();
        tabPane.getTabs().add(0, partnerTab);
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        selectionModel.select(partnerTab);
        try {
            //agentSearchComboBox.getItems().add("");
            List<String> columnsList = DBQuery.getElementColumns("ServiceProvider");
            for (String c : columnsList)
                partnerSearchComboBox.getItems().add(toArEn(c));
            partnerSearchComboBox.getSelectionModel().select(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showGuideMenu(ActionEvent event) {
        initGuideTableView();
        tabPane.getTabs().add(0, guideTab);
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        selectionModel.select(guideTab);
    }

    @FXML
    private void showAdMenu(ActionEvent event) {
        initAdvertisementTableView();
        tabPane.getTabs().add(0, adTab);
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        selectionModel.select(adTab);
        try {
            List<String> columnsList = DBQuery.getElementColumns("Advertisement");
            for (String c : columnsList)
                adSearchComboBox.getItems().add(toArEn(c));
            adSearchComboBox.getSelectionModel().select(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showAgentMenu(ActionEvent event) {
        initAgentTableView();
        tabPane.getTabs().add(0, agentTab);
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        selectionModel.select(agentTab);
        agentSearchComboBox.getItems().clear();
        try {
            //agentSearchComboBox.getItems().add("");
            List<String> columnsList = DBQuery.getElementColumns("Agent");
            for (String c : columnsList)
                agentSearchComboBox.getItems().add(toArEn(c));
            agentSearchComboBox.getSelectionModel().select(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showScheduleMenu(ActionEvent event) {
        initScheduleTableView();
        tabPane.getTabs().add(0, scheduleTab);
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        selectionModel.select(scheduleTab);
    }

    @FXML
    private void showTravelReport(ActionEvent event) throws Exception {
        initTravelReport();
        tabPane.getTabs().add(0, travelReportTab);
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        selectionModel.select(travelReportTab);
        
    }
    
    private void initTravelReport() throws Exception {
        List<TrvReport> trvReportList = DBQuery.getTrvReportData(DBQuery.getTravelID());
        generateTravelReport(trvReportList, travelReportPane);
    }
    
    private void generateTravelReport(List<TrvReport> trvReportList,AnchorPane pane){    
        pane.getChildren().clear();
        VBox[] v;
        v = new VBox[4];
            for(int b=0;b<4;b++){
               v[b] = new VBox();
               v[b].setSpacing(10);
               pane.getChildren().add(v[b]);
           }
         
        v[0].setPadding(new Insets(70,20,10,20));
        v[1].setPadding(new Insets(70,20,10,520));
        v[2].setPadding(new Insets(70,20,10,1020));
        v[3].setPadding(new Insets(70,20,10,1520));
        
        for(int i=0;i<trvReportList.size();i++){

        v[0].getChildren().add(makeLabel("رقم الرحلة: "  +Integer.toString(trvReportList.get(i).getId()) ));
        v[1].getChildren().add(makeLabel("عنوان الرحلة: " + trvReportList.get(i).getTitle() ));
        v[2].getChildren().add(makeLabel( "تاريخ إنشاء الرحلة: " +trvReportList.get(i).getCreatDate().toString()));
        v[3].getChildren().add(makeLabel( "حالة الرحلة: " +trvReportList.get(i).getIdle()));

        v[0].getChildren().add(makeLabel("عدد أيام الرحلة: " +Integer.toString(trvReportList.get(i).getDayNum()) ));
        v[1].getChildren().add(makeLabel("تاريخ بداية الرحلة: "+ trvReportList.get(i).getStartDate().toString() ));
        v[2].getChildren().add(makeLabel( "تاريخ نهاية الرحلة: "  +trvReportList.get(i).getEndDate().toString()));
        v[3].getChildren().add(makeLabel( "سعر الرحلة للفرد الواحد: " +Double.toString(trvReportList.get(i).getPrice())));

        v[0].getChildren().add(makeLabel("إجمالي عدد السياح المشتركين: " +Integer.toString(trvReportList.get(i).getTurNum()) ));
        v[1].getChildren().add(makeLabel("إجمالي عدد وسائل النقل المشاركة: " + Integer.toString(trvReportList.get(i).getTrsNum())));
        v[2].getChildren().add(makeLabel( "التكلفة الإجمالية لوسائل النقل المشاركة: "  +Double.toString(trvReportList.get(i).getTrsCost())));
        v[3].getChildren().add(makeLabel( "إجمالي عدد أماكن الإقامة المحجوزة: " +Integer.toString(trvReportList.get(i).getHstNum())));

        v[0].getChildren().add(makeLabel("التكلفة الإجمالية لأماكن الإقامة المحجوزة: " +Double.toString(trvReportList.get(i).getHstCost()) ));
        v[1].getChildren().add(makeLabel("إجمالي عدد المرشدين السياحين: " + Integer.toString(trvReportList.get(i).getGudNum())));
        v[2].getChildren().add(makeLabel( "التكلفة الإجمالية للمرشدين السياحين: "  +Double.toString(trvReportList.get(i).getGudCost())));
        v[3].getChildren().add(makeLabel( "إجمالي عدد الأماكن السياحية المسجلة: " +Integer.toString(trvReportList.get(i).getPlcNum())));

        v[0].getChildren().add(makeLabel("التكلفة الإجمالية لزيارة للأماكن السياحية: "  +Double.toString(trvReportList.get(i).getPlcCost()) ));
        v[1].getChildren().add(makeLabel("إجمالي عدد الأعلانات المنشورة: " + Integer.toString(trvReportList.get(i).getAdNum())));
        v[2].getChildren().add(makeLabel( "التكلفة الإجمالية للأعلانات المنشورة: " +Double.toString(trvReportList.get(i).getAdCost())));
        v[3].getChildren().add(makeLabel( "إجمالي عائدات الرحلة: " +Double.toString(trvReportList.get(i).getTrvProfit())));

        v[0].getChildren().add(makeLabel( "إجمالي تكلفة الرحلة: "  +Double.toString(trvReportList.get(i).getTrvCost())));
        v[1].getChildren().add(makeLabel( "صافي ربح الرحلة: "+Double.toString(trvReportList.get(i).getTrvNetProfit())));
        v[2].getChildren().add(makeLabel( ""));
        v[3].getChildren().add(makeLabel( ""));
        
        v[0].getChildren().add(makeLabel( "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"));
        v[1].getChildren().add(makeLabel( ""));
        v[2].getChildren().add(makeLabel( ""));
        v[3].getChildren().add(makeLabel( ""));
        
        
        
        }
       
       
    } 
      
    private Label makeLabel(String s){
        Label l = new Label(s);
        l.setTextFill(Color.web("#0076a3"));
        l.setStyle("-fx-background-color:   #e0e0e0e0;");
        l.setStyle("-fx-font-family: 'Courier New';");
       // l.setStyle("-fx-border-color:  #e0e0e0e0;");
        //l.setStyle("-fx-background-color:  #8a8888;");
        return l;
    }

    @FXML
    private void searchAgent(KeyEvent event) {
        if (agentSearchText.getText()== null){
            refreshAgentTableView();
        } else {
      
        agentTable.getItems().clear();

        List<Agent> angetList = null;
        try{
            angetList = DBQuery.getResAgent(DBQuery.getSearch("Agent",toArEn(agentSearchComboBox.getValue()), agentSearchText.getText()));
        }catch(Exception e){
        }
        if(angetList != null)
            for (Agent agent : angetList)
                agentTable.getItems().add(agent);
        }
    }

    @FXML
    private void searchTourist(KeyEvent event) {
         if (touristSearchText.getText()== null){
            refreshTouristTableView();
        } else {
      
         touristTable.getItems().clear();

        List<Tourist> touristList = null;
        try{
            touristList = DBQuery.getResTourist(DBQuery.getSearch("Tourist",toArEn(touristSearchComboBox.getValue()), touristSearchText.getText()));
        }catch(Exception e){
        }
        if(touristList != null)
            for (Tourist tourist : touristList)
                touristTable.getItems().add(tourist);
        }
    }

    @FXML
    private void searchPlace(KeyEvent event) {
        if (placeSearchText.getText()== null){
            refreshPlaceTableView();
        } else {
      
         placeTable.getItems().clear();

        List<Place> placeList = null;
        try{
            placeList = DBQuery.getResPlace(DBQuery.getSearch("Place",toArEn(placeSearchComboBox.getValue()), placeSearchText.getText()));
        }catch(Exception e){
        }
        if(placeList != null)
            for (Place place : placeList)
                placeTable.getItems().add(place);
        }
    }

    @FXML
    private void showTransportMenu(ActionEvent event) {
        initTransportTableView();
        tabPane.getTabs().add(0, transportTab);
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        selectionModel.select(transportTab);
        try {
            //agentSearchComboBox.getItems().add("");
            List<String> columnsList = DBQuery.getElementColumns("Transport");
            for (String c : columnsList)
                transportSearchComboBox.getItems().add(toArEn(c));
            transportSearchComboBox.getSelectionModel().select(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showTransportServiceMenu(ActionEvent event) {
        initTransportServiceTableView();
        tabPane.getTabs().add(0, transportServiceTab);
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        selectionModel.select(transportServiceTab);
        try {
            //agentSearchComboBox.getItems().add("");
            List<String> columnsList = DBQuery.getElementColumns("ServiceProvider");
            for (String c : columnsList)
                transportServiceSearchComboBox.getItems().add(toArEn(c));
            transportServiceSearchComboBox.getSelectionModel().select(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showHostelServiceMenu(ActionEvent event) {
        initHostelServiceTableView();
        tabPane.getTabs().add(0, hostelServiceTab);
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        selectionModel.select(hostelServiceTab);
        try {
            //agentSearchComboBox.getItems().add("");
            List<String> columnsList = DBQuery.getElementColumns("ServiceProvider");
            for (String c : columnsList)
                hostelServiceSearchComboBox.getItems().add(toArEn(c));
            hostelServiceSearchComboBox.getSelectionModel().select(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showAdServiceMenu(ActionEvent event) {
        initAdServiceTableView();
        tabPane.getTabs().add(0, adServiceTab);
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        selectionModel.select(adServiceTab);
        try {
            //agentSearchComboBox.getItems().add("");
            List<String> columnsList = DBQuery.getElementColumns("ServiceProvider");
            for (String c : columnsList)
                adServiceSearchComboBox.getItems().add(toArEn(c));
            adServiceSearchComboBox.getSelectionModel().select(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showAboutMenu(ActionEvent event) {
    }

    @FXML
    private void refreshTransport(ActionEvent event) {
    }

    @FXML
    private void addTransport(ActionEvent event) {
    }

    @FXML
    private void editTransport(ActionEvent event) {
    }

    @FXML
    private void deleteTransport(ActionEvent event) {
    }

    @FXML
    private void refreshHostel(ActionEvent event) {
    }

    @FXML
    private void addHostel(ActionEvent event) {
    }

    @FXML
    private void editHostel(ActionEvent event) {
    }

    @FXML
    private void deleteHostel(ActionEvent event) {
    }

    @FXML
    private void refreshTransportService(ActionEvent event) {
        refreshTransportServiceTableView();
    }

    @FXML
    private void addTransportService(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TransportServiceWindow.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setTitle("Domestic Tourism System");
            stage.getIcons().add(new Image("/icon.png"));
            stage.setScene(scene);
            stage.showAndWait();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void editTransportService(ActionEvent event) {
        TransportService trans = transportServiceTable.getSelectionModel().getSelectedItem();
        if (trans == null)
            return;
        
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TransportServiceWindow.fxml"));
            Parent root = loader.load();
            TransportServiceWindowController controller = loader.getController();
            controller.setEditOp(true);
            controller.setTrans(trans);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setTitle("Domestic Tourism System");
            stage.getIcons().add(new Image("/icon.png"));
            stage.setScene(scene);
            stage.showAndWait();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteTransportService(ActionEvent event) {
        TransportService trans = transportServiceTable.getSelectionModel().getSelectedItem();
        try {
            DBQuery.deleteServiceProvider(trans);
        } catch (Exception e) {
        }
        refreshTransportServiceTableView();
    }

    @FXML
    private void refreshHostelService(ActionEvent event) {
        refreshHostelServiceTableView();
    }

    @FXML
    private void addHostelService(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HostelServiceWindow.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setTitle("Domestic Tourism System");
            stage.getIcons().add(new Image("/icon.png"));
            stage.setScene(scene);
            stage.showAndWait();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void editHostelService(ActionEvent event) {
        HostelService host = hostelServiceTable.getSelectionModel().getSelectedItem();
        if (host == null)
            return;
        
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HostelServiceWindow.fxml"));
            Parent root = loader.load();
            HostelServiceWindowController controller = loader.getController();
            controller.setEditOp(true);
            controller.setHost(host);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setTitle("Domestic Tourism System");
            stage.getIcons().add(new Image("/icon.png"));
            stage.setScene(scene);
            stage.showAndWait();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteHostelService(ActionEvent event) {
        HostelService host = hostelServiceTable.getSelectionModel().getSelectedItem();
        try {
            DBQuery.deleteServiceProvider(host);
        } catch (Exception e) {
        }
        refreshHostelServiceTableView();
    }

    @FXML
    private void refreshAdService(ActionEvent event) {
        refreshAdServiceTableView();
    }

    @FXML
    private void addAdService(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdServiceWindow.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setTitle("Domestic Tourism System");
            stage.getIcons().add(new Image("/icon.png"));
            stage.setScene(scene);
            stage.showAndWait();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void editAdService(ActionEvent event) {
        AdService ad = adServiceTable.getSelectionModel().getSelectedItem();
        if (ad == null)
            return;
        
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdServiceWindow.fxml"));
            Parent root = loader.load();
            AdServiceWindowController controller = loader.getController();
            controller.setEditOp(true);
            controller.setAd(ad);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setTitle("Domestic Tourism System");
            stage.getIcons().add(new Image("/icon.png"));
            stage.setScene(scene);
            stage.showAndWait();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteAdService(ActionEvent event) {
        AdService ad = adServiceTable.getSelectionModel().getSelectedItem();
        try {
            DBQuery.deleteServiceProvider(ad);
        } catch (Exception e) {
        }
        refreshAdServiceTableView();
    }

    @FXML
    private void refreshAd(ActionEvent event) {
    }

    @FXML
    private void addAd(ActionEvent event) {
    }

    @FXML
    private void editAd(ActionEvent event) {
    }

    @FXML
    private void deleteAd(ActionEvent event) {
    }

    @FXML
    private void refreshRegTourist(ActionEvent event) {
        refreshRegTouristTableView(Travel.getSelectedTravel());
        
    }

    @FXML
    private void addRegTourist(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RegTouristWindow.fxml"));
            Parent root = loader.load();
            // RegTouristWindowController controller = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.setTitle("Domestic Tourism System");
            stage.getIcons().add(new Image("/icon.png"));
            stage.showAndWait();
        }catch(Exception e){
        }
    }

    @FXML
    private void deleteRegTourist(ActionEvent event) {
        RegTourist regTourist = regTouristTable.getSelectionModel().getSelectedItem();
        try {
            DBQuery.deleteRegTourist(regTourist);
        } catch (Exception e) {
        }
        refreshRegTouristTableView(Travel.getSelectedTravel());
    }

    @FXML
    private void refreshRegPlace(ActionEvent event) {
        refreshRegPlaceTableView(Travel.getSelectedTravel());
    }

    @FXML
    private void addRegPlace(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RegPlaceWindow.fxml"));
            Parent root = loader.load();
            // RegPlaceWindowController controller = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setTitle("Domestic Tourism System");
            stage.getIcons().add(new Image("/icon.png"));
            stage.setScene(scene);
            
            stage.showAndWait();
        }catch(Exception e){
        }
    }

    @FXML
    private void deleteRegPlace(ActionEvent event) {
        RegPlace regPlace = regPlaceTable.getSelectionModel().getSelectedItem();
        try {
            DBQuery.deleteRegPlace(regPlace);
        } catch (Exception e) {
        }
        refreshRegPlaceTableView(Travel.getSelectedTravel());
    }

    @FXML
    private void refreshRegGuide(ActionEvent event) {
        refreshRegGuideTableView(Travel.getSelectedTravel());
    }

    @FXML
    private void addRegGuide(ActionEvent event) {
    }

    @FXML
    private void deleteRegGuide(ActionEvent event) {
    }

    @FXML
    private void refreshRegTransport(ActionEvent event) {
        refreshRegTransportTableView(Travel.getSelectedTravel());
    }

    @FXML
    private void addRegTransport(ActionEvent event) {
         try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RegTransportWindow.fxml"));
            Parent root = loader.load();
            // RegTransportWindowController controller = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.setTitle("Domestic Tourism System");
            stage.getIcons().add(new Image("/icon.png"));
            stage.showAndWait();
        }catch(Exception e){
        }
    }

    @FXML
    private void deleteRegTransport(ActionEvent event) {
         RegTransport regTransport = regTransportTable.getSelectionModel().getSelectedItem();
        try {
            DBQuery.deleteRegTransport(regTransport);
        } catch (Exception e) {
        }
        refreshRegPlaceTableView(Travel.getSelectedTravel());
    }

    @FXML
    private void refreshRegHostel(ActionEvent event) {
        refreshRegHostelTableView(Travel.getSelectedTravel());
    }

    @FXML
    private void addRegHostel(ActionEvent event) {
    }

    @FXML
    private void deleteRegHostel(ActionEvent event) {
    }

    @FXML
    private void refreshPartner(ActionEvent event) {
        refreshPartnerTableView();
    }

    @FXML
    private void addPartner(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PartnerServiceWindow.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setTitle("Domestic Tourism System");
            stage.getIcons().add(new Image("/icon.png"));
            stage.setScene(scene);
            stage.showAndWait();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void editPartner(ActionEvent event) {
        Partner prt = partnerTable.getSelectionModel().getSelectedItem();
        if (prt == null)
            return;
        
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PartnerServiceWindow.fxml"));
            Parent root = loader.load();
            PartnerServiceWindowController controller = loader.getController();
            controller.setEditOp(true);
            controller.setPartner(prt);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setTitle("Domestic Tourism System");
            stage.getIcons().add(new Image("/icon.png"));
            stage.setScene(scene);
            stage.showAndWait();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void deletePartner(ActionEvent event) {
        Partner prt = partnerTable.getSelectionModel().getSelectedItem();
        try {
            DBQuery.deleteServiceProvider(prt);
        } catch (Exception e) {
        }
        refreshPartnerTableView();
    }

    @FXML
    private void refreshRegCampaign(ActionEvent event) {
        refreshCampaignTableView(Travel.getSelectedTravel());
    }

    @FXML
    private void addRegCampaign(ActionEvent event) {
    }

    @FXML
    private void deleteRegCampaign(ActionEvent event) {
    }

    @FXML
    private void searchAd(KeyEvent event) {
    }

    @FXML
    private void searchGuide(KeyEvent event) {
    }

    @FXML
    private void searchTravel(KeyEvent event) {
    }

    @FXML
    private void searchTransport(KeyEvent event) {
    }

    @FXML
    private void searchHostel(KeyEvent event) {
    }

    @FXML
    private void searchPartner(KeyEvent event) {
        if (partnerSearchText.getText() == null){
            refreshPartnerTableView();
        } else {
      
            partnerTable.getItems().clear();

            List<Partner> list = null;
            try{
                list = DBQuery.getResPartner(DBQuery.getSearch("ServiceProvider",
                        toArEn(partnerSearchComboBox.getValue()), partnerSearchText.getText()));
            }catch(Exception e){
                e.printStackTrace();
            }
            if(list != null)
                for (Partner prt : list)
                    if("prt".equals(prt.getCls()))
                        partnerTable.getItems().add(prt);
        }
    }

    @FXML
    private void searchTransportService(KeyEvent event) {
        if (transportSearchText.getText() == null){
            refreshTransportServiceTableView();
        } else {
      
            transportServiceTable.getItems().clear();

            List<TransportService> list = null;
            try{
                list = DBQuery.getResTransportService(DBQuery.getSearch("ServiceProvider",
                        toArEn(transportServiceSearchComboBox.getValue()),
                        transportServiceSearchText.getText()));
            }catch(Exception e){
                e.printStackTrace();
            }
            if(list != null)
                for (TransportService trs : list)
                    if("trs".equals(trs.getCls()))
                        transportServiceTable.getItems().add(trs);
        }
    }

    @FXML
    private void searchHostelService(KeyEvent event) {
        if (hostelServiceSearchText.getText() == null){
            refreshHostelServiceTableView();
        } else {
      
            hostelServiceTable.getItems().clear();

            List<HostelService> list = null;
            try{
                list = DBQuery.getResHostelService(DBQuery.getSearch("ServiceProvider",
                        toArEn(hostelServiceSearchComboBox.getValue()),
                        hostelServiceSearchText.getText()));
            }catch(Exception e){
                e.printStackTrace();
            }
            if(list != null)
                for (HostelService hst : list)
                    if("hst".equals(hst.getCls()))
                        hostelServiceTable.getItems().add(hst);
        }
    }

    @FXML
    private void searchAdService(KeyEvent event) {
        if (adServiceSearchText.getText() == null){
            refreshAdServiceTableView();
        } else {
      
            adServiceTable.getItems().clear();

            List<AdService> list = null;
            try{
                list = DBQuery.getResAdService(DBQuery.getSearch("ServiceProvider",
                        toArEn(adServiceSearchComboBox.getValue()),
                        adServiceSearchText.getText()));
            }catch(Exception e){
                e.printStackTrace();
            }
            if(list != null)
                for (AdService ad : list)
                    if("ad".equals(ad.getCls()))
                        adServiceTable.getItems().add(ad);
        }
    }

    @FXML
    private void searchRegisteration(KeyEvent event) {
        //if (registerationSearchText.getText()== null){
          //  refreshRegTouristTableView(Travel.getSelectedTravel());
        //} else {
      
       /* TabPane tab = new TabPane();
        String id;
            id = registerationTabPane.getSelectionModel().getSelectedItem().getId();
        *///switch (id){
        //    case "regTouristTab": 
            //regTouristTable.getItems().clear();
       // }
        
        
     Optional<RegTourist> observableList = regTouristTable.getItems().stream().filter(item -> item.getTouristName().contains(registerationSearchText.getText())).findAny();
     //Optional<RegTourist> observableList = regTouristTable.getItems().stream().filter(item -> item.getTouristName().contains(registerationSearchText.getText())).findAny();
     regTouristTable.getSelectionModel().select(observableList.orElse(null));
//.ifPresent(item -> {
        //regTouristTable.getSelectionModel().select(item);
       // regTouristTable.scrollTo(item);
       //regTouristTable.getItems().containsAll(registerationSearchText.getText());
    //});*/
        /*
       
        List<Agent> angetList = null;
        try{
            angetList = DBQuery.getResAgent(DBQuery.getSearch("Agent",toArEn(agentSearchComboBox.getValue()), agentSearchText.getText()));
        }catch(Exception e){
        }
        if(angetList != null)
            for (Agent agent : angetList)
                agentTable.getItems().add(agent);
        }*/
    }

}
