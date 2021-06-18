import java.util.Scanner;
public class Main
{
  static String tens_result (int tens, String[]two_digits,
			     String[]tens_multiple, int ones_place,
			     String[]single_digits)
  {
    String result_str = "";
    String print_ones_place = "";
    if (tens != 0)
      {
	if (tens == 1)
	  result_str += two_digits[ones_place];
	else
	  result_str += tens_multiple[tens] + " ";
      }
    if (ones_place > 0)
      {
	if (tens > 1)
	  {
	    print_ones_place += single_digits[ones_place];
	  }
      }
    else if (ones_place > 0 && tens == 0)
      {
	print_ones_place += single_digits[ones_place];
      }
    else
      {
	print_ones_place = " ";
      }
    result_str += print_ones_place;

    return result_str;
  }

  public static void main (String[]args)
  {
    Scanner my_scanner = new Scanner (System.in);
    String[]single_digits ={
    "Zero", "One", "Two", "Three",
	"Four", "Five", "Six", "Seven", "Eight", "Nine"};

    String[]two_digits ={
    "Ten", "Eleven", "Twelve",
	"Thirteen", "Fourteen", "Fifteen",
	"Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    String[]tens_multiple ={
    "", "", "Twenty", "Thirty", "Forty",
	"Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    String[]tens_power ={
    "Hundred", "Thousand"};
    int number = 123;
    int ones_place = number % 10;
    int tens = (number / 10) % 10;
    int hundreds = (number / 100) % 10;
    int thousands = number / 1000;
    String result_str_thousands = "";
    String hundreds_print = "";
    String number_in_str = Integer.toString (number);
    int number_in_str_len = number_in_str.length ();
    if (number_in_str_len == 1)
      System.out.println (single_digits[ones_place]);
    else if (number_in_str_len == 2)
      System.out.println (tens_result
			  (tens, two_digits, tens_multiple, ones_place,
			   single_digits));
    else if (number_in_str_len == 3)
      System.out.println (single_digits[hundreds] + " " + tens_power[0] +
			  " " + tens_result (tens, two_digits, tens_multiple,
					     ones_place, single_digits));
    else if (number_in_str_len == 4)
      {
    	result_str_thousands +=
    	  single_digits[thousands] + " " + tens_power[1];
    	if (hundreds != 0)
    	  {
    	    hundreds_print =
    	      " " + single_digits[hundreds] + " " + tens_power[0];
    	    result_str_thousands += hundreds_print;
    	  }
    	else
    	  {
    	    result_str_thousands += " ";
    	  }
    	result_str_thousands +=
    	  " " + tens_result (tens, two_digits, tens_multiple, ones_place,
    			     single_digits);
    	System.out.println (result_str_thousands);
      }
    else
      {
	System.out.printf
	  ("Sorry this version won't support %d digits, You get it in next update.. :-)",
	   number_in_str_len);
      }
  }
}
