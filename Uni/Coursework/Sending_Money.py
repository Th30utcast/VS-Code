"""
In this problem, i took the approach of a weighted graph, where the nodes are the friends, and the edges are the amount of money owed.
I used dictionaries to represent the graph. I frist start by calculating the net balance for each friend, a postive balance means the amount a friend is owed
(creditors), and the negative balance means the amount a friend owes (debtors), and a balance of 0 is neither, therefore we ignore it. I calculate the balance by checking
what is the "income" (money owed) that a freind has and what "debt" (money owes) they have as well, and subtract those to get the net balance.
The settle_debt functions sorts the creditors and debtors based on the amount they are owed (income) or own (debt), i then use a greedy algorithim that iterativley
matches the largest creditor with the largerst debtor, which continues until all debts are settled, each transaction is recorced and then printed. 
"""


def make_dic(matrix):
    net_balances = {}

    for debt in matrix:
        xi, yi, ci = debt

        # initialize balance to 0
        if xi not in net_balances:
            net_balances[xi] = 0
        if yi not in net_balances:
            net_balances[yi] = 0

        # Update the balances
        net_balances[xi] -= ci
        net_balances[yi] += ci

    return net_balances


def creditors(net_balances):
    creditors = {}
    for key, value in net_balances.items():
        if value > 0:
            creditors[key] = value

    return creditors


def debtors(net_balances):
    debtors = {}
    for key, value in net_balances.items():
        if value < 0:
            debtors[key] = -value

    return debtors


def settle_debt(creditors, debtors):
    transactions = []

    """ 
    Refrence: https://www.w3schools.com/python/python_lambda.asp
    Sort in descending order.
    """
    creditors_l = sorted(creditors.items(), key=lambda x: x[1], reverse=True)
    debtors_l = sorted(debtors.items(), key=lambda x: x[1], reverse=True)

    c_index, d_index = 0, 0

    # Loop until we settled all debts
    while c_index < len(creditors_l) and d_index < len(debtors_l):
        creditor, credit_amount = creditors_l[c_index]
        debtor, debt_amount = debtors_l[d_index]

        transaction_amount = min(credit_amount, debt_amount)
        transactions.append(
            (debtor, creditor, transaction_amount)
        )  # record the transactions

        # update the lists
        creditors_l[c_index] = (creditor, credit_amount - transaction_amount)
        debtors_l[d_index] = (debtor, debt_amount - transaction_amount)

        # If their balance has been fully settled move
        if credit_amount <= debt_amount:
            c_index += 1
        if debt_amount <= credit_amount:
            d_index += 1

    return transactions


def main():
    string_s = input()
    numbers = string_s.split()
    columns = int(numbers[0])
    rows = int(numbers[1])
    matrix = []
    for _ in range(rows):
        row = [int(x) for x in input().split()]
        matrix.append(row)

    net_balances = make_dic(matrix)
    creditors_dict = creditors(net_balances)
    debtors_dict = debtors(net_balances)
    transactions = settle_debt(creditors_dict, debtors_dict)

    total_amount = sum(transaction[2] for transaction in transactions)

    print(total_amount)
    for transaction in transactions:
        print(f"{transaction[0]} {transaction[1]} {transaction[2]}")


main()
