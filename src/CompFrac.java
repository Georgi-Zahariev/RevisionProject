public class CompFrac {
	private Fraction re, im;

	public CompFrac() {
		re = new Fraction();
		im = new Fraction();
	}

	public CompFrac(long a, long b) {
		re = new Fraction(a, b);
		im = new Fraction();
	}

	public CompFrac(long a, long b, long c, long d) {
		re = new Fraction(a, b);
		im = new Fraction(c, d);
	}

	public CompFrac(Fraction a, Fraction b) {
		re = a;
		im = b;
	}

	public Fraction getRe() {
		return re;
	}

	public Fraction getIm() {
		return im;
	}

	public void setRe(long a, long b) {
		re = new Fraction(a, b);
	}

	public void setIm(long a, long b) {
		im = new Fraction(a, b);
	}

	public CompFrac add(CompFrac a) {
		return new CompFrac(this.re.add(a.re), im.add(a.im));
	}

	public CompFrac sub(CompFrac a) {
		return new CompFrac(re.sub(a.re), im.sub(a.im));
	}

	public CompFrac mul(CompFrac a) {
		return new CompFrac(a.re.mul(re).sub(a.im.mul(im)), a.re.mul(im).add(a.im.mul(re)));
	}

	@Override
	public String toString() {
		if (re.getDen() == 0 || im.getDen() == 0)
			return "Invalid";
		if (im.getNum() == 0)
			return re.toString();
		String imag = im.toString();
		if (imag.indexOf('/') >= 0) {
			if (imag.charAt(0) == '-')
				imag = "-(" + imag.substring(1) + ")i";
			else
				imag = "(" + imag + ")i";
		} else {
			if (imag.equals("1"))
				imag = "i";
			else if (imag.equals("-1"))
				imag = "-i";
			else
				imag = imag + "i";
		}
		if (re.getNum() == 0)
			return imag;
		String s = re.toString();
		if (im.getNum() > 0)
			s += '+';
		return s + imag;
	}
}
