import sys
input = sys.stdin.readline

def get_cutted_wood(trees, cut):
    """현재 높이 cut일 때, 가져갈 수 있는 나무 총량 계산"""
    return sum(tree - cut for tree in trees if tree > cut)

N, M = map(int, input().split())
trees = list(map(int, input().split()))

pl, pr = 0, max(trees)  # 초기 높이 범위 설정
result = 0

while pl <= pr:
    pc = pl + (pr - pl) // 2  # 이진 탐색 중간값 설정
    cuttedTree = get_cutted_wood(trees, pc)  # 나무를 자르고 얻을 수 있는 총 나무 길이 계산

    if cuttedTree < M:
        pr = pc - 1  # 원하는 나무 길이보다 적으면 더 낮은 높이로 설정
    else:
        result = pc  # 현재 높이에서 M 이상 얻을 수 있으면 기록
        pl = pc + 1  # 더 높은 높이에서도 가능할지 확인

print(result)