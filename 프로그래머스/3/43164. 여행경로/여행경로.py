from collections import defaultdict
from copy import deepcopy

def solution(tickets):
    graph = defaultdict(list)
    for depart, dest in tickets:
        graph[depart].append(dest)

    # 사전순 우선 탐색 위해 내림차순 정렬 (pop으로 쓰기 위해)
    for key in graph:
        graph[key].sort(reverse=True)

    count = len(tickets)
    answer = []

    def dfs(curr, route, graph_copy):
        if len(route) ==count + 1:
            return route

        if curr not in graph_copy or not graph_copy[curr]:
            return None

        for i in range(len(graph_copy[curr]) - 1, -1, -1):  # 뒤에서부터 pop을 위한 반복
            next_graph = deepcopy(graph_copy)
            dest = next_graph[curr].pop(i)

            new_route = dfs(dest, route + [dest], next_graph)
            if new_route:
                return new_route

        return None

    return dfs("ICN", ["ICN"], graph)