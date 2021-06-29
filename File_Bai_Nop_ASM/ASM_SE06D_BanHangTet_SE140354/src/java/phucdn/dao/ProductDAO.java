/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import phucdn.db.MyConnection;
import phucdn.dtos.ProductDTO;

/**
 *
 * @author phucd
 */
public class ProductDAO {

    public Connection con;
    public PreparedStatement stm;
    public ResultSet rs;

    public void closeConnection() throws SQLException, ClassNotFoundException {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ProductDTO> findProductByProductID(String search)
            throws SQLException, ClassNotFoundException {
        List<ProductDTO> result = null;
        ProductDTO dto = null;
        String productID;
        String categoryID;
        String productName;
        String image;
        String description;
        double price;
        int quantity;
        int sale;
        String unit;
        boolean status;
        result = new ArrayList<>();
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "select productID, categoryID, productName, image, "
                        + "description, price, quantity, sale, unit, status\n"
                        + "from Product where productID like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    productID = rs.getString("productID");
                    categoryID = rs.getString("categoryID");
                    productName = rs.getString("productName");
                    image = rs.getString("image");
                    description = rs.getString("description");
                    price = rs.getDouble("price");
                    quantity = rs.getInt("quantity");
                    sale = rs.getInt("sale");
                    unit = rs.getString("unit");
                    status = rs.getBoolean("status");
                    dto = new ProductDTO(productID, categoryID, productName, image, description, price, quantity, sale, unit, status);
                    result.add(dto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<ProductDTO> getAllProduct() throws SQLException, ClassNotFoundException {
        List<ProductDTO> result = null;
        ProductDTO dto = null;
        String productID;
        String categoryID;
        String productName;
        String image;
        String description;
        double price;
        int quantity;
        int sale;
        result = new ArrayList<>();
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "select productID, categoryID, productName, image, "
                        + "description, price, quantity, sale \n"
                        + "from Product ";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    productID = rs.getString("productID");
                    categoryID = rs.getString("categoryID");
                    productName = rs.getString("productName");
                    image = rs.getString("image");
                    description = rs.getString("description");
                    price = rs.getDouble("price");
                    quantity = rs.getInt("quantity");
                    sale = rs.getInt("sale");
                    dto = new ProductDTO(productID, categoryID, productName, image, description, price, quantity, sale);
                    result.add(dto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean updateProduct(ProductDTO dto) throws Exception {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "update Product set categoryID = ?, productName = ?,"
                        + " description =?, price = ?, quantity = ?, sale = ?, unit = ?\n"
                        + "where productID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getCategoryID());
                stm.setString(2, dto.getProductName());
                stm.setString(3, dto.getDescription());
                stm.setDouble(4, dto.getPrice());
                stm.setInt(5, dto.getQuantity());
                stm.setInt(6, dto.getSale());
                stm.setString(7, dto.getUnit());
                stm.setString(8, dto.getProductID());
                check = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            System.out.println("Error at updateProduct: ");
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return check;
    }

    public boolean deleteProduct(String search) throws Exception {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "delete Product where productID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, search);
                check = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            System.out.println("Error at deleteProduct: ");
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }

    public ProductDTO findProductByPrimaryKey(String search) {
        ProductDTO dto = null;
        String categoryID;
        String productName;
        String image;
        String description;
        double price;
        int quantity;
        int sale;
        String unit;
        boolean status;
        Timestamp dateOfPost;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "select categoryID, productName, image, "
                        + "description, price, quantity, sale, unit, status, "
                        + "dateOfPost\n"
                        + "from Product where productID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, search);
                rs = stm.executeQuery();
                if (rs.next()) {
                    categoryID = rs.getString("categoryID");
                    productName = rs.getString("productName");
                    image = rs.getString("image");
                    description = rs.getString("description");
                    price = rs.getDouble("price");
                    quantity = rs.getInt("quantity");
                    sale = rs.getInt("sale");
                    unit = rs.getString("unit");
                    status = rs.getBoolean("status");
                    dateOfPost = rs.getTimestamp("dateOfPost");
                    dto = new ProductDTO(search, categoryID, productName, image, description, price, quantity, sale, unit, dateOfPost, status);
                }
            }
        } catch (Exception e) {
            System.out.println("Error at findProductByPrimaryKey: ");
            e.printStackTrace();
        } finally {
            try {
                closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return dto;
    }

    public ProductDTO getLastProduct() throws Exception {
        ProductDTO lastProduct = null;
        String productID;
        String categoryID;
        String productName;
        String image;
        double price;
        String unit;
        Timestamp dateOfPost;
        int quantity;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "select top 1 productID, categoryID, productName, image,price, "
                        + "unit, dateOfPost, quantity\n"
                        + "from Product\n"
                        + "order by dateOfPost desc";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                if (rs.next()) {
                    productID = rs.getString("productID");
                    categoryID = rs.getString("categoryID");
                    productName = rs.getString("productName");
                    image = rs.getString("image");
                    price = rs.getDouble("price");
                    unit = rs.getString("unit");
                    dateOfPost = rs.getTimestamp("dateOfPost");
                    quantity = rs.getInt("quantity");
                    lastProduct = new ProductDTO(productID, categoryID, productName, image, price, unit, dateOfPost, quantity);

                }
            }
        } catch (Exception e) {
            System.out.println("Error at getLastProduct: ");
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return lastProduct;
    }

    public List<ProductDTO> getTop3NewProduct() throws Exception {
        List<ProductDTO> result = new ArrayList<>();
        ProductDTO p = null;
        String productID;
        String categoryID;
        String productName;
        String image;
        double price;
        String unit;
        Timestamp dateOfPost;
        int quantity;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "select top 3 productID, categoryID, productName, \n"
                        + "image,price, unit, dateOfPost, quantity \n"
                        + "from Product \n"
                        + "order by dateOfPost desc";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    productID = rs.getString("productID");
                    categoryID = rs.getString("categoryID");
                    productName = rs.getString("productName");
                    image = rs.getString("image");
                    price = rs.getDouble("price");
                    unit = rs.getString("unit");
                    dateOfPost = rs.getTimestamp("dateOfPost");
                    quantity = rs.getInt("quantity");
                    p = new ProductDTO(productID, categoryID, productName, image, price, unit, dateOfPost, quantity);
                    result.add(p);
                }
            }
        } catch (Exception e) {
            System.out.println("Error at getTop3NewProduct: ");
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<ProductDTO> getAllProductByCateID(String search) throws Exception {
        List<ProductDTO> result = null;
        ProductDTO dto = null;
        String productID;
        String categoryID;
        String productName;
        String image;
        String description;
        double price;
        int quantity;
        int sale;
        result = new ArrayList<>();
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "select productID, categoryID, productName, image, "
                        + "description, price, quantity, sale\n"
                        + "from Product where categoryID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, search);
                rs = stm.executeQuery();
                while (rs.next()) {
                    productID = rs.getString("productID");
                    categoryID = rs.getString("categoryID");
                    productName = rs.getString("productName");
                    image = rs.getString("image");
                    description = rs.getString("description");
                    price = rs.getDouble("price");
                    quantity = rs.getInt("quantity");
                    sale = rs.getInt("sale");
                    dto = new ProductDTO(productID, categoryID, productName, image, description, price, quantity, sale);
                    result.add(dto);
                }
            }
        } catch (Exception e) {
            closeConnection();
        }
        return result;
    }

    public List<ProductDTO> findProductLikeByName(String search) throws Exception {
        List<ProductDTO> result = new ArrayList<>();
        ProductDTO dto = null;
        String productID;
        String categoryID;
        String productName;
        String image;
        String description;
        double price;
        int quantity;
        int sale;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "select productID, categoryID, productName, "
                        + "image, description, price, quantity, sale\n"
                        + "from Product where productName like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    productID = rs.getString("productID");
                    categoryID = rs.getString("categoryID");
                    productName = rs.getString("productName");
                    image = rs.getString("image");
                    description = rs.getString("description");
                    price = rs.getDouble("price");
                    quantity = rs.getInt("quantity");
                    sale = rs.getInt("sale");
                    dto = new ProductDTO(productID, categoryID, productName, image, description, price, quantity, sale);
                    result.add(dto);
                }
            }
        } catch (Exception e) {
            System.out.println("Error at findProductLikeByName:");
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<ProductDTO> getTopTenProduct() throws Exception {
        List<ProductDTO> result = new ArrayList<>();
        ProductDTO dto = null;
        String productID;
        String categoryID;
        String productName;
        String image;
        String description;
        double price;
        int quantity;
        int sale;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "select TOP 10 productID, categoryID, productName, image, "
                        + "description, price, quantity, sale \n"
                        + "from Product";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    productID = rs.getString("productID");
                    categoryID = rs.getString("categoryID");
                    productName = rs.getString("productName");
                    image = rs.getString("image");
                    description = rs.getString("description");
                    price = rs.getDouble("price");
                    quantity = rs.getInt("quantity");
                    sale = rs.getInt("sale");
                    dto = new ProductDTO(productID, categoryID, productName, image, description, price, quantity, sale);
                    result.add(dto);
                }
            }
        } catch (Exception e) {
            System.out.println("Error at getTopThreeProduct:");
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    //ham tra ve 3 san pham tiep theo dua theo ma san pham va so luong san pham da hien thi
    public List<ProductDTO> getNextTenProduct(int amount) throws Exception {
        List<ProductDTO> result = new ArrayList<>();
        ProductDTO dto = null;
        String productID;
        String categoryID;
        String productName;
        String image;
        String description;
        double price;
        int quantity;
        int sale;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "select productID, categoryID, productName, image,\n"
                        + "description, price, quantity, sale \n"
                        + "from Product\n"
                        + "ORDER BY productID\n"
                        + "OFFSET ? ROWS\n"
                        + "FETCH NEXT 10 ROWS ONLY";
                stm = con.prepareStatement(sql);
                stm.setInt(1, amount);
                rs = stm.executeQuery();
                while (rs.next()) {
                    productID = rs.getString("productID");
                    categoryID = rs.getString("categoryID");
                    productName = rs.getString("productName");
                    image = rs.getString("image");
                    description = rs.getString("description");
                    price = rs.getDouble("price");
                    quantity = rs.getInt("quantity");
                    sale = rs.getInt("sale");
                    dto = new ProductDTO(productID, categoryID, productName, image, description, price, quantity, sale);
                    result.add(dto);
                }
            }
        } catch (Exception e) {
            System.out.println("Error at getTopThreeProduct:");
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean insertProduct(ProductDTO proDTO) throws Exception {
        boolean result = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "insert Product(productID,categoryID,"
                        + "productName,[image],price,quantity,sale,"
                        + "[description],unit,status,dateOfPost)\n"
                        + "values (?,?,?,?,?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, proDTO.getProductID());
                stm.setString(2, proDTO.getCategoryID());
                stm.setString(3, proDTO.getProductName());
                stm.setString(4, proDTO.getImage());
                stm.setDouble(5, proDTO.getPrice());
                stm.setInt(6, proDTO.getQuantity());
                stm.setInt(7, proDTO.getSale());
                stm.setString(8, proDTO.getDescription());
                stm.setString(9, proDTO.getUnit());
                stm.setBoolean(10, proDTO.isStatus());
                stm.setTimestamp(11, proDTO.getDateOfPost());
                result = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean deleteProduct2(String id) throws Exception {
        boolean result = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "update Product set [status] = 'false' where productID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                result = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            System.out.println("Error at deleteProduct2: ");
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean reActivatePro(String id) throws Exception {
        boolean result = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "update Product set [status] = 'true' where productID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                result = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            System.out.println("Error at reActivatePro: ");
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean updateQuantityProduct(String id, int quantity) throws Exception {
        boolean result = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "update Product set quantity = quantity - ?\n"
                        + "where productID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, quantity);
                stm.setString(2, id);
                result = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            System.out.println("Error at updateQuantityProduct: ");
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean returnQuantityProduct(String id, int quantity) throws Exception {
        boolean result = false;

        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "update Product set quantity = quantity + ?\n"
                        + "where productID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, quantity);
                stm.setString(2, id);
                result = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            System.out.println("Error at returnQuantityProduct: ");
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<ProductDTO> getRecommenItems(String search) throws Exception {
        List<ProductDTO> result = new ArrayList<>();
        ProductDTO dto = null;
        String productID;
        String categoryID;
        String productName;
        String image;
        String description;
        double price;
        int quantity;
        int sale;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "select top 6 productID, categoryID, productName, image, "
                        + "description, price, quantity, sale\n"
                        + "from Product where categoryID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, search);
                rs = stm.executeQuery();
                while (rs.next()) {
                    productID = rs.getString("productID");
                    categoryID = rs.getString("categoryID");
                    productName = rs.getString("productName");
                    image = rs.getString("image");
                    description = rs.getString("description");
                    price = rs.getDouble("price");
                    quantity = rs.getInt("quantity");
                    sale = rs.getInt("sale");
                    dto = new ProductDTO(productID, categoryID, productName, image, description, price, quantity, sale);
                    result.add(dto);
                }
            }
        } catch (Exception e) {
            System.out.println("Error at getRecommenItems: ");
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<ProductDTO> getProductOutOfCateID(String id) throws Exception {
        List<ProductDTO> result = new ArrayList<>();
        ProductDTO dto = null;
        String productID;
        String categoryID;
        String productName;
        String image;
        String description;
        double price;
        int quantity;
        int sale;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "select productID, categoryID, productName, image, "
                        + "description, price, quantity, sale\n"
                        + "from Product where categoryID != ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                while (rs.next()) {
                    productID = rs.getString("productID");
                    categoryID = rs.getString("categoryID");
                    productName = rs.getString("productName");
                    image = rs.getString("image");
                    description = rs.getString("description");
                    price = rs.getDouble("price");
                    quantity = rs.getInt("quantity");
                    sale = rs.getInt("sale");
                    dto = new ProductDTO(productID, categoryID, productName, image, description, price, quantity, sale);
                    result.add(dto);
                }
            }
        } catch (Exception e) {
            System.out.println("Error at getProductOutOfCateID: ");
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean updateProductOnCateID(String cateID, String proID) throws Exception {
        boolean result = false;
        ProductDTO dto = null;
        String categoryID;
        String productID;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "update Product set categoryID = ?\n"
                        + "where productID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, cateID);
                stm.setString(2, proID);
                result = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            System.out.println("Error at updateProductOnCateID: ");
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        ProductDAO proDAO = new ProductDAO();
//        List<ProductDTO> listP = proDAO.getAllProductByCateID("st01");
//        for (ProductDTO p : listP) {
//            System.out.println(p);
//        }
        long mills = System.currentTimeMillis();
        Timestamp dateOfPost = new Timestamp(mills);
//        proDAO.updateQuantityProduct("SP10000001", 10);

//        ProductDTO dto = new ProductDTO("SP100046", "st01", "bamhquy", "https://media3.scdn.vn/img3/2018/12_22/hSVNOX_simg_de2fe0_500x500_maxb.jpg", "", 90000, 1234, 12, "Hop", dateOfPost, true);
//        if (proDAO.insertProduct(dto)) {
//            System.out.println("Insert done !");
//        }
        if (proDAO.findProductByPrimaryKey("SP10000007") != null) {
            System.out.println("Find product is successfully!");
        }

        List<ProductDTO> listFind = proDAO.getProductOutOfCateID("st01");
        for (ProductDTO productDTO : listFind) {
            System.out.println(productDTO.toString());
        }
    }

}
