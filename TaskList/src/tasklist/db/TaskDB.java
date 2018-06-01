/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tasklist.db;

/**
 *
 * @author Austin LaBerta
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import tasklist.business.Task;
import tasklist.business.Validator;

public class TaskDB {
	
    private Connection connection;
	String getAll,
		   dbUrl;
    
    public TaskDB() {

        dbUrl = "jdbc:sqlite:task_list.sqlite";
		getAll = "SELECT * "
                   + "FROM Task ";
    }
	
	public void view() {
		String getAllNoCompletes = getAll
				+	"WHERE completed = 0;";
		int counter = 1;
		
		try {
			connection = DriverManager.getConnection(dbUrl);
		} catch (SQLException e) {
			System.err.println(e);
		}
		
        try (PreparedStatement ps = connection.prepareStatement(getAllNoCompletes)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String description = rs.getString("Description");
                boolean completed = rs.getBoolean("Completed");
                Task t = new Task(counter, description, completed);
				if(!completed) {
					System.out.println(t.toString());
					counter++;
				}
            }
			rs.close();
			ps.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
	}
	
	public void history() {
		String getAllCompletes = getAll		
				+	"WHERE completed = 1;";
		int counter = 1;
		
		try {
			connection = DriverManager.getConnection(dbUrl);
		} catch (SQLException e) {
			System.err.println(e);
		}
		
        try (PreparedStatement ps = connection.prepareStatement(getAllCompletes)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String description = rs.getString("Description");
                boolean completed = rs.getBoolean("Completed");
                Task t = new Task(counter, description, completed);
				if(completed) {
					System.out.println(t.toString());
					counter++;
				}
            }
			rs.close();
			ps.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
	}
	
	public void add(String s) throws SQLException {
		String sql = "INSERT INTO Task (description, completed)"
				   + " VALUES ('" + s + "', 0);";
		try {
			connection = DriverManager.getConnection(dbUrl);
		} catch (SQLException e) {
			System.err.println(e);
		}
		
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.err.println(e);
		}
		
	}
	
	public void complete(int i) throws SQLException {
		int counter = 0;
		boolean keepLooping = true;
		
		try {
			connection = DriverManager.getConnection(dbUrl);
		} catch (SQLException e) {
			System.err.println(e);
		}
		
        try (PreparedStatement ps = connection.prepareStatement(getAll)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next() && keepLooping) {
				int size = rs.getInt("taskID");
                boolean completed = rs.getBoolean("Completed");
				if(!completed) {
					counter++;
				}
				if (counter == i)
				{
					String sql = "UPDATE Task "
							   + "SET completed = 1 "
							   + "WHERE taskID = " + size + ";";
					try (PreparedStatement ps2 = connection.prepareStatement(sql)) {
						ps2.executeUpdate();
					} catch (SQLException e) {
						System.err.println(e);	
					}
					keepLooping = false;	
				}
				
            }
			rs.close();
			ps.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
	}
	
	public void delete(int i) throws SQLException {
		int counter = 0;
		boolean keepLooping = true;
		
		try {
			connection = DriverManager.getConnection(dbUrl);
		} catch (SQLException e) {
			System.err.println(e);
		}
		
        try (PreparedStatement ps = connection.prepareStatement(getAll)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next() && keepLooping) {
				int size = rs.getInt("taskID");
                boolean completed = rs.getBoolean("Completed");
				if(completed) {
					counter++;
				}
				if (counter == i)
				{
					String sql = "DELETE FROM Task "
							   + "WHERE taskID = " + size + ";";
					try (PreparedStatement ps2 = connection.prepareStatement(sql)) {
						ps2.executeUpdate();
						ps2.close();
					} catch (SQLException e) {
						System.err.println(e);	
					}
					keepLooping = false;	
				}
            }
			rs.close();
			ps.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
	}
	
		public void update(int i) throws SQLException {
		int counter = 0;
		boolean keepLooping = true;
		
		try {
			connection = DriverManager.getConnection(dbUrl);
		} catch (SQLException e) {
			System.err.println(e);
		}
		
        try (PreparedStatement ps = connection.prepareStatement(getAll)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next() && keepLooping) {
				int size = rs.getInt("taskID");
                boolean completed = rs.getBoolean("Completed");
				if(!completed) {
					counter++;
				}
				if (counter == i)
				{
					System.out.print("Description: ");
					Validator valid = new Validator();
					Scanner sc = new Scanner(System.in);
					String input = valid.validateStr(sc);
					
					String sql = "UPDATE Task "
							   + "SET description = '" + input + "' "
							   + "WHERE taskID = " + size + ";";
					try (PreparedStatement ps2 = connection.prepareStatement(sql)) {
						ps2.executeUpdate();
					} catch (SQLException e) {
						System.err.println(e);	
					}
					keepLooping = false;	
				}
				
            }
			rs.close();
			ps.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
	}
}
