package com.demo.backend.sbmssf.feb2025;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveStoreMapArea {
    private String id;
    private String category;
    private int rowStart;
    private int colStart;
    private int rowEnd;
    private int colEnd;
    private int storeId;
    private int gridX;
    private int gridY;
    private int inventoryModelId;


    @Override
    public String toString() {
        return "SaveStoreMapArea{" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                ", rowStart=" + rowStart +
                ", colStart=" + colStart +
                ", rowEnd=" + rowEnd +
                ", colEnd=" + colEnd +
                ", storeId=" + storeId +
                '}';
    }
}
