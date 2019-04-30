package proyecto.prueba.ejercicio1.mavenProyect0.dto;

/**
 * Hello world!
 *
 */






import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.XStreamException;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.mapper.CannotResolveClassException;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

 

/**

* Hello world!
 * @param <Clase>

*

*/

public class App<Clase>

{


    	public static void main (Strin[] args){
    	try
    		Clase clase = obtenerClase();
    			System.out.println(clase.getProfesor());
    			System.out.printls("-----------------"));
    			clase.getListaAlumnos().stream().sorted(Comparator.comparing(Alumdno::getApellidos)).foreach(System.out.println);
    			
    			
    		App (Exception e){
    			System.out.println("Error:"+e.toString());
    			
    		}
    		}
    {

       try {

             File fishero = new File("C:\\beca_java_2019\\EJERCICIOS\\alumnos.xml");

             Reader reader = new InputStreamReader(new FileInputStream(fishero), "ISO-8859-1");

             XStream xstream = new XStream(new StaxDriver()) {

                           protected MapperWrapper wrapMapper(MapperWrapper next) {

                                  return new MapperWrapper(next) {

                                        public boolean shouldSerializeMember(Class definedIn, String fieldName) {

                                               try {

                                                      return definedIn != Object.class || realClass(fieldName) != null;

                                               } catch (CannotResolveClassException cnrce) {

                                                      return false;

                                               }

                                        }

                                  };

                           }

                    };

                    xstream.addPermission(NoTypePermission.NONE);

                    xstream.addPermission(NullPermission.NULL);

                    xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);

                    xstream.allowTypeHierarchy(Collection.class);

                    xstream.allowTypesByWildcard(new String[] { "C:\\Users\\Administrador\\Desktop\\ALEJANDRO_OTERO*" });

                    xstream.ignoreUnknownElements();

                    xstream.processAnnotations(Clase.class);

                    Clase clase = (Clase) xstream.fromXML(reader);

                    xstream = null;

                    reader.close();

             } catch (Exception e) {

                    System.out.println("Error: "+e.toString());

             }

        System.out.println( "Hello World!" );

    }

}