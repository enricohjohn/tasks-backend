package br.ce.wcaquino.taskbackend.utils;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilsTest {



	@Test
	public void deveRetornarTrueParaDatasFuturas() {
		LocalDate date = LocalDate.of(2030, 1, 1);
		boolean equalOrFutureDate = DateUtils.isEqualOrFutureDate(date);
		Assert.assertTrue(equalOrFutureDate);
	}
	@Test
	public void deveRetornarFalseParaDatasFuturas() {
		LocalDate date = LocalDate.of(2010, 1,1);
		boolean equalOrFutureDate = DateUtils.isEqualOrFutureDate(date);
		Assert.assertFalse(equalOrFutureDate);
	}

	@Test
	public void deveRetornarTrueParaDataAtual() {
		LocalDate date = LocalDate.now();
		boolean equalOrFutureDate = DateUtils.isEqualOrFutureDate(date);
		Assert.assertTrue(equalOrFutureDate);
	}
}
