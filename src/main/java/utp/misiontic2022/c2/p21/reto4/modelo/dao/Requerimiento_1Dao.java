package utp.misiontic2022.c2.p21.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p21.reto4.modelo.vo.Requerimiento_1;
import utp.misiontic2022.c2.p21.reto4.util.JDBCUtilities;

public class Requerimiento_1Dao {
    public ArrayList<Requerimiento_1> requerimiento1() throws SQLException {
        var response = new ArrayList<Requerimiento_1>();

        String consulta = "SELECT Nombre_Material , Precio_Unidad" 
                        + " FROM MaterialConstruccion mc"
                        + " WHERE Importado = 'Si'"
                        + " ORDER BY Precio_Unidad DESC;";

        try(var connection = JDBCUtilities.getConnection();
            var statement = connection.prepareStatement(consulta);
            var rset = statement.executeQuery()){

                while(rset.next()){
                    var requerimiento_1VO = new Requerimiento_1();
                    requerimiento_1VO.setNombreMaterial(rset.getString("Nombre_Material"));
                    requerimiento_1VO.setPrecioUnidad(rset.getInt("Precio_Unidad"));

                    response.add(requerimiento_1VO);
                }                          
        }
        return response;
    }
}