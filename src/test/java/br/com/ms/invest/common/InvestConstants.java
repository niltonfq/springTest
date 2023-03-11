package br.com.ms.invest.common;

import java.math.BigInteger;

import br.com.ms.invest.modules.ativo.Ativo;
import br.com.ms.invest.modules.dominio.Dominio;
import br.com.ms.invest.modules.grupoUsuaria.GrupoUsuaria;
import br.com.ms.invest.modules.tipoAtivo.TipoAtivo;

public class InvestConstants {
	public static final GrupoUsuaria GRUPOUSUARIA = new GrupoUsuaria("a921f8d3-2aa2-4afb-90a0-a74dd102b734","usuaria");
	public static final Dominio MOEDA = new Dominio(BigInteger.ONE,"ATIVO","tipoAtivoId","R$","REAL");
	public static final TipoAtivo TIPOATIVO = new TipoAtivo(BigInteger.valueOf(14), "FII");
	public static final Ativo ATIVO = new Ativo(GRUPOUSUARIA, TIPOATIVO, "BCFF11", MOEDA);
	public static final Ativo ATIVOINVALIDO = new Ativo(GRUPOUSUARIA, TIPOATIVO, null, MOEDA);
}
