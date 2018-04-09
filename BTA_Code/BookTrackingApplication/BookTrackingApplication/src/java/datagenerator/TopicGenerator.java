/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datagenerator;

import activity.JDBC;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 108
 */
public class TopicGenerator {
    public static void main(String[] args) {

        int sub_id = 14;
        int numberOfTopics = 80;
        String topicPrefix = "topic-";
        JDBC dbfunc = new JDBC();
        dbfunc.createConnection();

        for (int i = 1; i <= numberOfTopics; i++) {
            try {
                String query = "INSERT INTO units (  `sub_id` ,\n"
                        + " `topicname`) VALUES (" + (sub_id) + ",'" + (topicPrefix.trim() + i) + "')";

                System.out.println("Query : " + query);

                if (dbfunc.updateRecord(query)) {
                    System.out.println("Topic Created");
                } else {
                    System.out.println("Topic Creation Failed");
                }
            } catch (SQLException ex) {
                Logger.getLogger(TopicGenerator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        dbfunc.closeConnection();

    }
}
