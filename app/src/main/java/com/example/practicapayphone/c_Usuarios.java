package com.example.practicapayphone;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class c_Usuarios {
    private String usuario;
    private String pass;
    private String nombres;
    private String imgUrl;
    private String mail;
    private String cPais;
    private String nCelu;
    private String nTarg;

    public String getcPais() {
        return cPais;
    }

    public void setcPais(String cPais) {
        this.cPais = cPais;
    }

    public String getnCelu() {
        return nCelu;
    }

    public void setnCelu(String nCelu) {
        this.nCelu = nCelu;
    }

    public String getnTarg() {
        return nTarg;
    }

    public void setnTarg(String nTarg) {
        this.nTarg = nTarg;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


    //public c_Usuarios(JSONObject a)  { //String nom, String are, String ide, String img1, String img2
    //    try {
    //        nombres = a.getString("full_name").toString() ;
    //        usuario = a.getString("user").toString() ;
    //        pass = a.getString("pass").toString() ;
    //        imgUrl = a.getString("img").toString() ;
    //        mail = a.getString("mail").toString() ;
    //    } catch (JSONException e) {
    //        System.out.println("Error: " + e.toString());
    //    }
    //}
    //public static ArrayList<c_Usuarios> JsonObjectsBuild(JSONArray datos) throws JSONException {
    //    ArrayList<c_Usuarios> users = new ArrayList<>();
    //
    //    for (int i = 0; i < datos.length() ; i++) {
    //        users.add(new c_Usuarios(datos.getJSONObject(i)));
    //    }
    //    return users;
    //}
}
