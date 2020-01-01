package logic;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PrintBigNum {

	private static String scaleName[] = { "million", "billion", "trillion", "quadrillion", "quintillion", "sextillion",
			"septillion" };

	public static String PrintBigNumForCookie(BigDecimal num) {
		String output = "";
		num = num.setScale(0, RoundingMode.DOWN);
		int stringlen = num.toString().length();
		if (stringlen > 6) {
			int divider = stringlen > 9 ? ((stringlen - 6) / 3) : 0;
			output += num.divide(BigDecimal.ONE.scaleByPowerOfTen((3 * divider) + 6)).setScale(3, RoundingMode.HALF_UP)
					.toString();
			output += " " + scaleName[divider];
		} else {
			if (stringlen > 3)
				output += num.divide(BigDecimal.ONE.scaleByPowerOfTen(3)).setScale(0, RoundingMode.DOWN).toString()
						+ ",";
			if (stringlen > 2)
				output += num.remainder(BigDecimal.ONE.scaleByPowerOfTen(3)).divide(BigDecimal.ONE.scaleByPowerOfTen(2))
						.setScale(0, RoundingMode.DOWN).toString();
			if (stringlen > 1)
				output += num.remainder(BigDecimal.ONE.scaleByPowerOfTen(2)).divide(BigDecimal.ONE.scaleByPowerOfTen(1))
						.setScale(0, RoundingMode.DOWN).toString();
			output += num.remainder(BigDecimal.ONE.scaleByPowerOfTen(1)).toString();
		}
		return output;
	}

	public static String PrintBigNumForPerSecond(BigDecimal num) {
		String output = "";
		if (num.compareTo(BigDecimal.ONE.scaleByPowerOfTen(3)) > -1 || num.compareTo(BigDecimal.ZERO) == 0) {
			output = PrintBigNumForCookie(num);
		} else if (num.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0) {
			output = PrintBigNumForCookie(num) + ".0";
		} else {
			output = num.setScale(1, RoundingMode.DOWN).toString();
		}
		return output;
	}

}