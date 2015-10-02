package test.com.model.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.model.TransformaStringMD5;

public class TransformaStringMD5Test {
	String senha;
	String md5Senha;
	String senhaErrada;
	String md5SenhaErrada;
	String senhaCorreta;
	String md5SenhaCorreta;

	@Before
	public void init() {
		senha = "123456";
		md5Senha = TransformaStringMD5.md5(senha);
		senhaErrada = "123457";
		md5SenhaErrada = TransformaStringMD5.md5(senhaErrada);
		senhaCorreta = "123456";
		md5SenhaCorreta = TransformaStringMD5.md5(senhaCorreta);
	}

	@Test
	public void testMd5Correto() {
		assertEquals(md5Senha, md5SenhaCorreta);
	}
	@Test
	public void testMd5Errado() {
		assertEquals(md5Senha, md5SenhaErrada);
	}

	@After
	public void end() {
		senha = null;
		md5Senha = null;
		senhaErrada = null;
		md5SenhaErrada = null;
		senhaCorreta = null;
		md5SenhaCorreta = null;
	}

}
