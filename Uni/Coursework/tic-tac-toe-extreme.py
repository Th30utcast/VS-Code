"""
This Tic-Tac-Toe Extreme game solver assesses if the first player can guarantee a win given the current state of an `n x n` grid and
remaining timeouts (`t1` and `t2`) for both players. The game allows players to mark cells in turns and use timeouts to skip the opponent's
turn. The solver employs a recursive strategy (`can_win_recursive`) to simulate all possible moves, evaluating whether any path leads to a
forced win for player one. It calculates scores for streaks of consecutive marks in rows and columns, with a streak defined as two or more
consecutive marks yielding points. User input is prompted for the grid size, timeouts, and the board's state, represented by `0` (empty),
`1` (player one's mark), or `2` (player two's mark). The solver then outputs "yes" if a winning strategy exists for player one or "no"
otherwise, effectively exploring all game paths to determine the outcome based on the given board state and timeouts.
"""


def score_line(line):
    score, streak = 0, 1  # Initialize score and streak
    for i in range(1, len(line) + 1):  # Add sentinel to handle the last element
        if i < len(line) and line[i] == line[i - 1] and line[i] != 0:
            streak += 1
        else:
            if streak > 1:  # Only count streaks of length > 1
                score += (streak * (streak + 1)) // 2
            streak = 1  # Reset streak for the next set
    return score


def evaluate_board(board):
    p1_score = p2_score = 0  # Initialize scores for both players
    n = len(board)

    # Score rows for both players
    for row in board:
        p1_score += score_line([1 if cell == 1 else 0 for cell in row])
        p2_score += score_line([1 if cell == 2 else 0 for cell in row])

    # Score columns for both players
    for col in zip(*board):
        p1_score += score_line([1 if cell == 1 else 0 for cell in col])
        p2_score += score_line([1 if cell == 2 else 0 for cell in col])

    return p1_score, p2_score


def can_win_recursive(board, t1, t2, turn):
    scores = evaluate_board(board)
    if all(cell != 0 for row in board for cell in row):  # Board is full
        return scores[0] > scores[1] if turn == 1 else scores[1] > scores[0]

    for i in range(len(board)):
        for j in range(len(board)):
            if board[i][j] == 0:
                board[i][j] = turn
                next_turn = 1 if turn == 2 else 2
                if turn == 1 and t1 > 0:  # Player one uses a timeout
                    can_other_win = not can_win_recursive(board, t1 - 1, t2, 1)
                elif turn == 2 and t2 > 0:  # Player two uses a timeout
                    can_other_win = can_win_recursive(board, t1, t2 - 1, 2)
                else:
                    can_other_win = not can_win_recursive(board, t1, t2, next_turn)
                board[i][j] = 0  # Undo move

                if (turn == 1 and not can_other_win) or (turn == 2 and can_other_win):
                    return True

    return False if turn == 1 else True


def main():
    n, t1, t2 = map(int, input().split())
    board = []
    for _ in range(n):
        row = list(map(int, list(input().strip())))
        board.append(row)

    if can_win_recursive(board, t1, t2, 1):
        print("yes")
    else:
        print("no")


if __name__ == "__main__":
    main()
