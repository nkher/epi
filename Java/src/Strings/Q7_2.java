package Strings;

import java.util.Arrays;

public class Q7_2 {

	/* Done in O(N) time complexity */
	public static char[] replaceAndRemove(char[] str, int length) {
		int num_b = 0, i;
		int write_index = 0, new_len = 0;	
		
		for (i=0;i<length;i++) {
			if (str[i] == 'a') {
				continue;
			} 
			else if (str[i] == 'b') {
				num_b++;
			}
			str[write_index++] = str[i];
			new_len++;
		}
		
		write_index = (new_len) + (2 * num_b) - 1;  // adjusting write_index according to the array bounds 
		
		new_len = new_len - 1; // adjusting new_len according to the array bounds
		
		System.out.println(Arrays.toString(str));
		
		while (new_len >= 0) {
			if (str[new_len] == 'b') {
				str[write_index] = 'e';
				str[write_index-1] = 'e';
				str[write_index-2] = 'b';
				write_index -= 3;
			} else {
				str[write_index] = str[new_len];
				write_index -= 1;
			}
			new_len--;
		}
				
		return str;
	}
	
	public static void main(String args[]) {
		
		char[] str = {'a', 'b', 's', 't', 'r', 'a', 'c', 't', ' ', ' ', ' ', ' '};
		
		System.out.println(Arrays.toString(replaceAndRemove(str, 8)));
		
		char[] s = {'a', 'b', 's', 'b', 'r', 'a', 'c', 't', ' ', ' ', ' ', ' ', ' ', ' '};
		
		System.out.println(Arrays.toString(replaceAndRemove(s, 8)));

	}

}
