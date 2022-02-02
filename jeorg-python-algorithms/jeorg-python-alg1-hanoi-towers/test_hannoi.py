A = [4, 3, 2, 1]
B = []
C = []

from hannoi import moveDisk


def test_move_disk():
    moveDisk(4, A, B, C)
    assert A == []
    assert B == [4, 3, 2, 1]
    assert C == []
