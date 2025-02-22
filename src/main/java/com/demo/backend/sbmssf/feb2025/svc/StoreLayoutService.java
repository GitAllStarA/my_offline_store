package com.demo.backend.sbmssf.feb2025.svc;

import com.demo.backend.sbmssf.feb2025.SaveStoreMapArea;
import com.demo.backend.sbmssf.feb2025.StoreLayoutModel;
import com.demo.backend.sbmssf.feb2025.repo.StoreLayoutRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class StoreLayoutService {
    @Autowired
    private StoreLayoutRepository storeLayoutRepository;
    @Autowired
    private StoreModelService storeModelService;

    public List<StoreLayoutModel> getLayoutByStore(Long storeModelId) {
        return storeLayoutRepository.findByStoreModelId(storeModelId);
    }

    String req = "{\"20\": [{\"storeId\": 1, \"inventoryId\": 1, \"category\": \"iPhone Display\", \"rowStart\": 3, \"colStart\": 6, \"rowEnd\": 6, \"colEnd\": 7}], \"21\": [{\"storeId\": 1, \"inventoryId\": 2, \"category\": \"iPhone Display\", \"rowStart\": 4, \"colStart\": 3, \"rowEnd\": 5, \"colEnd\": 4}], \"22\": [{\"storeId\": 1, \"inventoryId\": 4, \"category\": \"Samsung Display\", \"rowStart\": 3, \"colStart\": 2, \"rowEnd\": 4, \"colEnd\": 3}], \"23\": [{\"storeId\": 1, \"inventoryId\": 7, \"category\": \"Accessories\", \"rowStart\": 1, \"colStart\": 3, \"rowEnd\": 3, \"colEnd\": 7}], \"24\": [{\"storeId\": 1, \"inventoryId\": 8, \"category\": \"Billing\", \"rowStart\": 4, \"colStart\": 4, \"rowEnd\": 6, \"colEnd\": 5}], \"25\": [{\"storeId\": 1, \"inventoryId\": 9, \"category\": \"Customer Support\", \"rowStart\": 5, \"colStart\": 3, \"rowEnd\": 6, \"colEnd\": 4}], \"26\": [{\"storeId\": 1, \"inventoryId\": 10, \"category\": \"Waiting Area\", \"rowStart\": 2, \"colStart\": 1, \"rowEnd\": 3, \"colEnd\": 2}], \"27\": [{\"storeId\": 1, \"inventoryId\": 11, \"category\": \"Storage\", \"rowStart\": 4, \"colStart\": 5, \"rowEnd\": 5, \"colEnd\": 6}], \"28\": [{\"storeId\": 1, \"inventoryId\": 12, \"category\": \"Manager Office\", \"rowStart\": 3, \"colStart\": 3, \"rowEnd\": 4, \"colEnd\": 4}], \"29\": [{\"storeId\": 1, \"inventoryId\": 13, \"category\": \"Tech Repairs\", \"rowStart\": 5, \"colStart\": 2, \"rowEnd\": 6, \"colEnd\": 3}], \"36\": [{\"category\": \"Unlocked phones\", \"storeId\": 1, \"inventoryId\": 15, \"rowStart\": 0, \"colStart\": 4, \"rowEnd\": 1, \"colEnd\": 5}], \"37\": [{\"category\": \"Kiosk\", \"storeId\": 1, \"inventoryId\": 14, \"rowStart\": 0, \"colStart\": 5, \"rowEnd\": 1, \"colEnd\": 6}], \"storeInfo\": [{\"id\": 1, \"name\": \"AT&T Store Hutto\", \"address\": \"123 Main St\", \"city\": \"Hutto\", \"state\": \"TX\", \"zipCode\": \"78634\", \"squareFeet\": 2000, \"openingTime\": \"10:00:00\", \"closingTime\": \"20:00:00\"}]}";

    public void saveStoreMap(String requestStr) {
        System.out.println(req);
    }

    /*public static void main(String[] args) throws IOException {
        StoreLayoutService sl = new StoreLayoutService();
        sl.jsonParse(sl.req);
    }*/

    public boolean jsonParse(String req) throws IOException {

        StoreLayoutService sl = new StoreLayoutService();
        JSONObject jsonObject = new JSONObject(req);

        Iterator<String> jsonIterator = jsonObject.keys();
        List<SaveStoreMapArea> saveStoreMapAreas = new ArrayList<>();
        while (jsonIterator.hasNext()) {
            String keys = jsonIterator.next();
            String val = jsonObject.get(keys).toString();
            //System.out.println(keys.replace(" ","")+" : "+val);

            ObjectMapper objectMapper = new ObjectMapper();
            List<Map<String, Object>> listMaps = objectMapper.readValue(val, new TypeReference<List<Map<String, Object>>>() {
                    });
            for (int i = 0; i < listMaps.size(); i++) {

                SaveStoreMapArea saveStoreMapArea = new SaveStoreMapArea();
                if (keys.equalsIgnoreCase("storeInfo") ) {
                    System.out.println("not required to add the store info in store layout"+listMaps.get(i));

                } else {
                    saveStoreMapArea.setId(keys);
                    saveStoreMapArea.setCategory((String) listMaps.get(i).get("category"));
                    saveStoreMapArea.setRowStart((Integer) listMaps.get(i).get("rowStart"));
                    saveStoreMapArea.setColStart((Integer)listMaps.get(i).get("colStart"));
                    saveStoreMapArea.setRowEnd((Integer) listMaps.get(i).get("rowEnd"));
                    saveStoreMapArea.setColEnd((Integer) listMaps.get(i).get("colEnd"));
                    saveStoreMapArea.setStoreId((Integer) listMaps.get(i).get("storeId"));
                    saveStoreMapArea.setInventoryModelId((Integer) listMaps.get(i).get("inventoryId"));
                    saveStoreMapAreas.add(saveStoreMapArea);
                }
            }
        }

        for (SaveStoreMapArea saveStoreMapArea: saveStoreMapAreas) {
            Long storeLayoutId = Long.valueOf(saveStoreMapArea.getId());
            if (storeLayoutId == null) {
                System.out.println("storelayoutid not present :: " + storeLayoutId);
                return false;
            }

            Optional<StoreLayoutModel> storeLayoutModel = getStoreLayoutIdService(storeLayoutId);
            System.out.println(storeLayoutId + "::::::::::::::::::::::::::");
            if (storeLayoutModel == null || storeLayoutModel.isEmpty()) {
                System.out.println("storeLayoutModel :: category not found :: " + saveStoreMapArea.getCategory());
                System.out.println("adding the section_name/category and id to the store layout model :::::::::::");
                long storeModelId = saveStoreMapArea.getStoreId();
                //List<StoreLayoutModel> storeLayoutModels = storeLayoutRepository.findByStoreModelId(storeModelId);
                StoreLayoutModel saveNewCategory = new StoreLayoutModel();
                saveNewCategory.setId(Long.valueOf(saveStoreMapArea.getId()));
                saveNewCategory.setGridX(saveStoreMapArea.getGridX());
                saveNewCategory.setGridY(saveStoreMapArea.getGridY());
                saveNewCategory.setStoreModelId((long) saveStoreMapArea.getStoreId());
                saveNewCategory.setInventoryModelId((long) saveStoreMapArea.getInventoryModelId());
                saveNewCategory.setRowStart(saveStoreMapArea.getRowStart());
                saveNewCategory.setColStart(saveStoreMapArea.getColStart());
                saveNewCategory.setRowEnd(saveStoreMapArea.getRowEnd());
                saveNewCategory.setColEnd(saveStoreMapArea.getColEnd());
                saveNewCategory.setSectionName(saveStoreMapArea.getCategory());
                storeLayoutRepository.save(saveNewCategory);
            } else {
               // System.out.println("storelayoutmodel map data" + storeLayoutModel.get());
                if (storeModelService.getStoreById((long) saveStoreMapArea.getStoreId()).isPresent()) {
                    if (storeLayoutModel.isPresent()) {
                        if (storeLayoutModel.get().getSectionName().equalsIgnoreCase(saveStoreMapArea.getCategory())) {
                            storeLayoutModel.get().setRowStart(saveStoreMapArea.getRowStart());
                            storeLayoutModel.get().setColStart(saveStoreMapArea.getColStart());
                            storeLayoutModel.get().setRowEnd(saveStoreMapArea.getRowEnd());
                            storeLayoutModel.get().setColEnd(saveStoreMapArea.getColEnd());
                            save(storeLayoutModel.get());
                        } else {
                        System.out.println("storeLayoutModel :: category not found :: "+saveStoreMapArea.getCategory());
                        System.out.println("creating new category ");
                        storeLayoutModel.get().setSectionName(saveStoreMapArea.getCategory());
                        storeLayoutModel.get().setRowStart(saveStoreMapArea.getRowStart());
                        storeLayoutModel.get().setColStart(saveStoreMapArea.getColStart());
                        storeLayoutModel.get().setRowEnd(saveStoreMapArea.getRowEnd());
                        storeLayoutModel.get().setColEnd(saveStoreMapArea.getColEnd());
                        }
                    } else {
                        System.out.println("storeLayoutModel :: object not fount :: ");
                        return false;
                    }
                } else {
                    System.out.println("storeModelService :: store not present to update store layout map area");
                    return false;
                }
            }
        }
        System.out.println("jsonParse :: end of method save to db");
        return true;
    }

    public Optional<StoreLayoutModel> getStoreLayoutIdService(Long storeLayoutId) {
        if (storeLayoutId instanceof Long) {
             if(storeLayoutRepository.findById(storeLayoutId).isPresent()){
                 return storeLayoutRepository.findById(storeLayoutId);
             }
             else {
                 System.out.println("storelayout not present :: "+storeLayoutId);
             }
        }
        System.out.println("storelayout not present :: "+storeLayoutId);
        return null;
    }

    public void save(StoreLayoutModel saveNewLayoutUpdates) {
        storeLayoutRepository.save(saveNewLayoutUpdates);
    }
}
