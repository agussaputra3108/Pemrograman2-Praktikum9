/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package latihan.praktikum2.io;

import java.io.*;
import java.net.*;

/**
 *
 * @author Putra Tarihoran
 */
public class ChatServer {
    public static void main(String[] x) throws Exception {
        //1. Input Konfigurasi
        BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
        
        System.out.println("Masukkan Nama : ");
        String nama = input.readLine();
        System.out.println("Hallo "+nama);
        
        System.out.println("Masukkan port Anda : ");
        Integer port = Integer.parseInt(input.readLine());
        
        //System.out.println("Masukkan alamat IP tujuan : ");
        //String ipTujuan = input.readLine();
        
        //System.out.println("Masukkan port tujuan : ");
        //Integer portTujuan = Integer.parseInt(input.readLine());
        
        //2. Start socket server
        ServerSocket server = new ServerSocket(port);
        System.out.println("Menunggu Koneksi di Port "+port);
        
        //3. Terima Koneksi
                Socket koneksi = server.accept();
                System.out.print("Terima koneksi dari alamat IP ");
                System.out.println(((InetSocketAddress)koneksi.getRemoteSocketAddress()).getAddress());
        
        //4. tampilkan data selama belum bye
                BufferedReader chatIncoming = new BufferedReader(new InputStreamReader(koneksi.getInputStream()));
                
                String msg = chatIncoming.readLine();
                while(msg != null && !"bye".equalsIgnoreCase(msg)){
                    System.out.println(msg);
                    msg = chatIncoming.readLine();
                }
                
                chatIncoming.close();
                koneksi.close();
    }
}
