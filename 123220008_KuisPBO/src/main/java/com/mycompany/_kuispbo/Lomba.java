/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._kuispbo;

/**
 *
 * @author Lab Informatika
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lomba extends JFrame {
    private JFrame frame1, frame2, frame3;
    private JLabel namaLabel, sekolahLabel;
    private JLabel aLabel, bLabel, cLabel, dLabel; //label
    private JTextField namaField, sekolahField;
    private JTextField aField, bField, cField, dField; //field
    
    private JButton animasiButton, suratButton, showButton, editButton, exitButton;
    
    public Lomba() {
        frame1 = new JFrame("Pilih Lomba");
        frame1.setLayout(new FlowLayout());
        
        animasiButton = new JButton("Animasi");
        suratButton = new JButton("Menulis Surat");
        frame1.add(animasiButton);
        frame1.add(suratButton);
        
        animasiButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae){
               frame1.setVisible(false);
               showFrame2("Animasi");
           }
        });
        suratButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae){
               frame1.setVisible(false);
               showFrame2("MenulisSurat");
           }
        });
        
        frame1.setSize(300,100);
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);
    }
    
    private void showFrame2(String lombaType){
        frame2 = new JFrame("Input Data Nilai");
        frame2.setLayout(new GridLayout(7,2,5,5));
        
        namaLabel = new JLabel("Nama Peserta : ");
        namaField = new JTextField(30);
        sekolahLabel = new JLabel("Asal Sekolah : ");
        sekolahField = new JTextField(30);
        
        if(lombaType.equals("Animasi")) {
            aLabel = new JLabel("Alur Cerita : ");
            aField = new JTextField(3);
            bLabel = new JLabel("Konten : ");
            bField = new JTextField(3);
            cLabel = new JLabel("Kreativitas : ");
            cField = new JTextField(3);
            dLabel = new JLabel("Sinematografi : ");
            dField = new JTextField(3);
        } else if (lombaType.equals("MenulisSurat")) {
            aLabel = new JLabel("Struktur Surat : ");
            aField = new JTextField(3);
            bLabel = new JLabel("Isi Surat : ");
            bField = new JTextField(3);
            cLabel = new JLabel("Kreativitas : ");
            cField = new JTextField(3);
            dLabel = new JLabel("Kaidah Bahasa : ");
            dField = new JTextField(3);
        }
        
        showButton = new JButton("Tampilkan Hasil");
        editButton = new JButton("Edit Nilai");
        exitButton = new JButton("Keluar");
        
        String keterangan;
        double  totalSkor = 0;
        
        showButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                try {
                    if (namaField.getText().isEmpty() ||
                        sekolahField.getText().isEmpty() ||
                        aField.getText().isEmpty() ||
                        bField.getText().isEmpty() ||
                        cField.getText().isEmpty() ||
                        dField.getText().isEmpty()){
                        throw new IllegalArgumentException("Field Tidak Boleh Kosong");
                    }
                    
                    String nama = namaField.getText();
                    String sekolah = sekolahField.getText();
                    
                    double a = 0, b = 0, c = 0, d = 0;
                    
                    if(lombaType.equals("Animasi")){
                        a = Double.parseDouble(aField.getText()) * 15/100;
                        b = Double.parseDouble(bField.getText()) * 35/100;
                        c = Double.parseDouble(cField.getText()) * 35/100;
                        d = Double.parseDouble(dField.getText()) * 15/100;
                    }
                    else if(lombaType.equals("MenulisSurat")){
                        a = Double.parseDouble(aField.getText()) * 10/100;
                        b = Double.parseDouble(bField.getText()) * 40/100;
                        c = Double.parseDouble(cField.getText()) * 30/100;
                        d = Double.parseDouble(dField.getText()) * 20/100;
                    }
                    
                    totalSkor = a + b + c + d;
                    if(totalSkor >= 85) keterangan = "LOLOS"; else keterangan = "TIDAK LOLOS";
                    JOptionPane.showMessageDialog(null, "Nama\t: " + nama +"\n" +
                                                        "Asal Sekolah\t: " + sekolah + "\n" +
                                                        "Skor Akhir\t: " + totalSkor + "\n" +
                                                        keterangan);
                    
                } catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,"Masukkan Nilai Berupa Angka!");
                } catch(IllegalArgumentException ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        
        frame2.add(namaLabel);
        frame2.add(namaField);
        frame2.add(sekolahLabel);
        frame2.add(sekolahField);
        
        frame2.add(aLabel);
        frame2.add(aField);
        frame2.add(bLabel);
        frame2.add(bField);
        frame2.add(cLabel);
        frame2.add(cField);
        frame2.add(dLabel);
        frame2.add(dField);
        frame2.add(showButton);
        
        showButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae){
               frame2.setVisible(false);
               showFrame3(totalSkor,keterangan);
           }
        });
        
        frame2.setSize(500,400);
        frame2.setLocationRelativeTo(null);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);
    }
    
    private void showFrame3(double totalSkor, String keterangan){
        if(totalSkor >= 85) keterangan = "LOLOS"; else keterangan = "TIDAK LOLOS";
        JOptionPane.showMessageDialog(null, "Nama\t: " + nama +"\n" +
                                                        "Asal Sekolah\t: " + sekolah + "\n" +
                                                        "Skor Akhir\t: " + totalSkor + "\n" +
                                                        keterangan);
    }
    
    public static void main(String [] args){
        new Lomba();
    }
}
