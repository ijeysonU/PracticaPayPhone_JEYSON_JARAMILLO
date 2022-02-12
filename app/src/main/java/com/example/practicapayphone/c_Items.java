package com.example.practicapayphone;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class c_Items {
    private String item;
    private Double precio;
    private String imgURL;


    public c_Items(JSONObject items){
        try {
            item = items.getString("item");
            precio = items.getDouble("precioitem");
            imgURL = items.getString("img");
        }catch (JSONException exception){
            System.out.println("Error: "+exception.toString());
        }
    }
    public static ArrayList<c_Items> JsonObjectsBuild(JSONArray datos) {
        ArrayList<c_Items> item = new ArrayList<>();
        try {

            for (int i = 0; i < datos.length() ; i++) {
                item.add(new c_Items(datos.getJSONObject(i)));
            }
        }catch (JSONException ex){
            System.out.println("Error de items: "+ex.toString());
        }
        return item;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
}
