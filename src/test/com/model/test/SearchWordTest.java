package test.com.model.test;

import com.model.util.SearchWord;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by heitor on 05/10/15.
 */
public class SearchWordTest {
    private String teste = "Ola mundo @Heitor teste @bacon";
    private String teste2 = "Ola mundo #Heitor teste #bacon";
    private String teste3 = "Ola mundo @Heitor teste @bacon Ola mundo #Heitor teste #bacon";
    @Test
    public void testSearchAtSignAndNumberSign() throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        Set<String> setTeste =   SearchWord.searchAtSignAndNumberSign(teste3).get(0);
        for(String s: setTeste){
            stringBuffer.append(s);
        }

        Set<String> setTeste2 =   SearchWord.searchAtSignAndNumberSign(teste3).get(1);
        for(String s: setTeste2){
            stringBuffer.append(s);
        }
        assertEquals("@Heitor@bacon#Heitor#bacon", stringBuffer.toString());
    }

    @Test
    public void testSearchAtSign() throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        Set<String> setTeste =   SearchWord.searchAtSign(teste);
        for(String s: setTeste){
            stringBuffer.append(s);
        }
        assertEquals("@Heitor@bacon", stringBuffer.toString());
    }

    @Test
    public void testSearchNumberSign() throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        Set<String> setTeste2 =   SearchWord.searchNumberSign(teste2);
        for(String s: setTeste2){
            stringBuffer.append(s);
        }
        assertEquals("#Heitor#bacon", stringBuffer.toString());
    }
}