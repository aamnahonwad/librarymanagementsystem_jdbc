import java.sql.*;

public class BooksDAO {

    // CREATE
    public void addBook(Books b) {

        try (Connection conn = DBConnection.getConnection()){

            String sql = "INSERT INTO books(book_id,title,author,genre,price,available_copies) VALUES(?,?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, b.book_id);
            ps.setString(2, b.title);
            ps.setString(3, b.author);
            ps.setString(4, b.genre);
            ps.setDouble(5, b.price);
            ps.setInt(6, b.available_copies);

            ps.executeUpdate();

            System.out.println("Book Added Successfully");

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    // READ
    public void viewBooks() {

        try (Connection conn = DBConnection.getConnection()){

            String sql = "SELECT * FROM books";

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                System.out.println(
                        rs.getInt("book_id") + " | "
                        + rs.getString("title") + "|"
                        + rs.getString("author") + "|"
                        + rs.getString("genre") + "|"
                        + rs.getDouble("price") + "|"
                        + rs.getInt("available_copies")
                );
            }

        } catch (SQLException e) {
             System.out.println("Error: " + e);
        }
    }

//byid
    public void getBookById(int id) {
        try (Connection conn = DBConnection.getConnection()){

            String sql = "SELECT * FROM books WHERE book_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(
                        rs.getInt("book_id") + " | "
                        + rs.getString("title") + "|"
                        + rs.getString("author") + "|"
                        + rs.getString("genre") + "|"
                        + rs.getDouble("price") + "|"
                        + rs.getInt("available_copies")
                );
            } else {
                System.out.println("Book not found");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }


    // DELETE
    public void deleteBook(int id) {

        try(Connection conn = DBConnection.getConnection()){

            String sql = "DELETE FROM books WHERE book_id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Book Deleted");

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    
    // UPDATE title
    public void updateTitle(int id,String title) {

        try (Connection conn = DBConnection.getConnection()){
         
            String sql = "UPDATE books  SET title=?  WHERE book_id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, title);
            ps.setInt(2, id);
          

            ps.executeUpdate();

            System.out.println("Title Updated");

        } catch (SQLException e) {
             System.out.println("Error: " + e);
        }
    }


    // Update price
    public void updatePrice(int id,Double price) {
        try (Connection conn = DBConnection.getConnection()){

            String sql = "UPDATE books SET price=? WHERE book_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, price);
            ps.setInt(2, id);

            ps.executeUpdate();
            System.out.println("price updated");
        } catch (Exception e) {
             System.out.println("Error: " + e);
        }
    }

    // Update copies
    public void updateCopies(int id,int copies) {
        try(Connection conn = DBConnection.getConnection()){
            String sql = "UPDATE books SET available_copies=? WHERE book_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, copies);
            ps.setInt(2, id);
            ps.executeUpdate();

            System.out.println("copies Updated");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

   // ISSUE BOOK
    public void issueBook(int id) {
        try (Connection conn = DBConnection.getConnection()) {

            String check = "SELECT available_copies FROM books WHERE book_id=?";
            PreparedStatement ps1 = conn.prepareStatement(check);
            ps1.setInt(1, id);

            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {
                int copies = rs.getInt("available_copies");

                if (copies > 0) {
                    String sql = "UPDATE books SET available_copies = available_copies - 1 WHERE book_id=?";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setInt(1, id);
                    ps.executeUpdate();

                    System.out.println("Book Issued");
                } else {
                    System.out.println("No copies available");
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

  // RETURN BOOK
    public void returnBook(int id) {
        try (Connection conn = DBConnection.getConnection()) {

            String sql = "UPDATE books SET available_copies = available_copies + 1 WHERE book_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Book Returned");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}

