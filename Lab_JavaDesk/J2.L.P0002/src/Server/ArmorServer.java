/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DTO.ArmorDTO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class ArmorServer extends UnicastRemoteObject implements ArmorInterface {

    public static String filename = "D:\\Software Engineer FPTU\\Season 4\\Lab_JavaDesk\\J2.L.P0002\\data.txt";
//    public File file = new File(filename);

    public ArmorServer() throws RemoteException {
    }

//    public static void readFromFile() {
//        try {
//            File f = new File(filename);
//            FileReader fr = new FileReader(f);
//            BufferedReader bf = new BufferedReader(fr);
//            String details;
//            while ((details = bf.readLine()) != null) {
//                StringTokenizer stk = new StringTokenizer(details, ",");
//                String AwrmorID = stk.nextToken();
//                String Classification = stk.nextToken();
//                String Status = stk.nextToken();
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH/mm");
//                Date TimeOfCreate = sdf.parse(stk.nextToken());
//                int Denfense = Integer.parseInt(stk.nextToken());
//                ArmorDTO arm = new ArmorDTO(AwrmorID, Classification, Classification, Status, TimeOfCreate, Denfense);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public boolean createArmor(ArmorDTO dto) {
//        String filename = "D:\\Software Engineer FPTU\\Season 4\\Lab_JavaDesk\\J2.L.P0002\\data.txt";
        File file = new File(filename);
        boolean result = false;

        if (!file.exists()) {
            JOptionPane.showMessageDialog(null, "The file does not existed!");
        }

        try {
            PrintWriter pf = new PrintWriter(file);

        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public ArmorDTO findByArmorID(String id) {
//        String filename = "D:\\Software Engineer FPTU\\Season 4\\Lab_JavaDesk\\J2.L.P0002\\data.txt";
        File file = new File(filename);
        ArmorDTO result = null;
        try {

        } catch (Exception e) {
        } finally {
            try {

            } catch (Exception e) {
            }
        }
        return result;
    }

    @Override
    public List<ArmorDTO> findAllArmor() {
//        String filename = "D:\\Software Engineer FPTU\\Season 4\\Lab_JavaDesk\\J2.L.P0002\\data.txt";
        File file = new File(filename);
        List<ArmorDTO> result = new ArrayList<>();
        try {

        } catch (Exception e) {
        } finally {
            try {

            } catch (Exception e) {
            }
        }
        return result;
    }

    @Override
    public boolean removeArmor(String id) {
//        String filename = "D:\\Software Engineer FPTU\\Season 4\\Lab_JavaDesk\\J2.L.P0002\\data.txt";
        File file = new File(filename);
        boolean result = false;
        if (!file.exists()) {
            JOptionPane.showMessageDialog(null, "The file doesn't have data for deleting!");
        }
        try {

        } catch (Exception e) {
        }

        return result;
    }

    @Override
    public boolean updateArmor(ArmorDTO dto) {
//        String filename = "D:\\Software Engineer FPTU\\Season 4\\Lab_JavaDesk\\J2.L.P0002\\data.txt";
        File file = new File(filename);
        boolean result = false;
        if (!file.exists()) {
            JOptionPane.showMessageDialog(null, "The file doesn't have data for updating!");
        }
        try {

        } catch (Exception e) {
        }

        return result;
    }

}
