public class RationalNumber extends RealNumber
{
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *  If the denominator is negative, negate both numerator and denominator
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    super(0.0);//this value is ignored!
    if (deno == 0) {
      nume = 0;
      deno = 1;
    }
    if (deno < 0) {
      nume *= -1;
      deno *= -1;
    }
    numerator = nume;
    denominator = deno;

    reduce();
  }

  public double getValue(){
    return (double)numerator/denominator;
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    return (new RationalNumber(denominator, numerator));
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    return (numerator == other.numerator && denominator == other.denominator);
  }


  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    if (numerator == 0) {
      return "0";
    } else if (denominator == 1) {
      return numerator + "";
    } else {
    return (numerator + "/" + denominator);
    }
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    /*use euclids method or a better one*/
    if (a == 0) {
      return b;
    } else if (b == 0) {
      return a;
    }
    while (a != b) {
      if (a > b) {
        a -= b;
      } else {
        b -= a;
      }
    }
    return a;
  }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    numerator /= (gcd(Math.abs(numerator), denominator));
    denominator /= (gcd(Math.abs(numerator), denominator));
  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    return (new RationalNumber(numerator * other.numerator,
    denominator * other.denominator));
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    return (multiply(other.reciprocal()));
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    int commonDeno = denominator * other.denominator;
    int nume1 = numerator * other.denominator;
    int nume2 = other.numerator * denominator;
    return new RationalNumber(nume1 + nume2, commonDeno);
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    int commonDeno = denominator * other.denominator;
    int nume1 = numerator * other.denominator;
    int nume2 = other.numerator * denominator;
    return new RationalNumber(nume1 - nume2, commonDeno);
  }
}
