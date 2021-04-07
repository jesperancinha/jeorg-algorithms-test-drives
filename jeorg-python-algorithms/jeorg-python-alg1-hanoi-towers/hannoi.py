A = [4, 3, 2, 1]
B = []
C = []

def moveDisk(n, startPeg, targetPeg, helperPeg):
    if n > 0:
        moveDisk(n - 1, startPeg, helperPeg, targetPeg)
        targetPeg.append(startPeg.pop())
        print(A, B, C)
        moveDisk(n - 1, helperPeg, targetPeg, startPeg)
moveDisk(4, A, C, B)