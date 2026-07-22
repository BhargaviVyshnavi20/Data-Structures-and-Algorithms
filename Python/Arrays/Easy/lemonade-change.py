"""
Problem Link:
https://leetcode.com/problems/lemonade-change/

Approaches:

1. Greedy 
   Maintain the count of available $5 and $10 bills while processing each customer.
   - Collect $5 bills.
   - Use one $5 bill as change for a $10 bill.
   - For a $20 bill, always prioritize giving one $10 and one $5 before
     using three $5 bills, as this preserves more $5 bills for future transactions.
   - Time: O(n)
   - Space: O(1)
"""

def lemonade_change(bills: List[int]) -> bool:
    five = 0
    ten = 0

    for bill in bills:

        if bill == 5:
            five += 1

        elif bill == 10:
            if five:
                five -= 1
                ten += 1
            else:
                return False

        else:
            if five and ten:
                five -= 1
                ten -= 1
            elif five >= 3:
                five -= 3
            else:
                return False

    return True