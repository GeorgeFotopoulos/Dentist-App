package com.example.efarmoghgiaodontiatrous.view.AndroidUtil;


//Class with function to set checkbox as Checked in ordewr to save the checked Items
public class ListViewItemDTO {

    private boolean checked = false;

    private String itemText = "";

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getItemText() {
        return itemText;
    }

    public void setItemText(String itemText) {
        this.itemText = itemText;
    }
}