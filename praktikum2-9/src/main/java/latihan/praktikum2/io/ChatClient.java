/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package latihan.praktikum2.io;

import java.io.*;
import java.net.*;

//import java.io.BufferedReader;
//import java.net.Socket;

/**
 *
 * @author Putra Tarihoran
 */
public class ChatClient {
    public static void main(String[] xx) throws Exception {
        //1. Input konfigurasi
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Masukkan Nama : ");
        String nama = input.readLine();
        System.out.println("Hallo "+nama);
            
        System.out.println("Masukkan alamat IP tujuan : ");
        String ipTujuan = input.readLine();
        
        System.out.println("masukkan port tujuan : ");
        Integer portTujuan = Integer.parseInt(input.readLine());
                
        //2. Buka Koneksi
        Socket s = new Socket(ipTujuan, portTujuan);
        System.out.println("Berhasil connect ke "+ipTujuan+":"+portTujuan);
        
        //3. kirim data
        BufferedReader chat = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(s.getOutputStream(), true);
        
        String msg = chat.readLine();
        while(msg != null && !"bye".equalsIgnoreCase(msg)){
            output.println(nama+"> "+msg);
            msg = chat.readLine();
        }
        chat.close();
        output.close();
        s.close();
   }
}
    