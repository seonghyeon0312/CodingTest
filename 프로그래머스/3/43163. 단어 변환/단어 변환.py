def solution(begin, target, words):
    answer = 0

    length = len(begin) + 1
    visited = [False for _ in range(len(words))]
    result = 0

    if target not in words:
        return answer
    def diff(word1, word2):
        count = 0
        for i in range(len(word1)):
            if word1[i] != word2[i]:
                count += 1

        return count

    def dfs(n, prev,result):
        if diff(prev, target) == 0:
            result = min(result, n)
            return result

        for i in range(len(words)):
            if not visited[i]:
                if diff(prev, words[i]) == 1:
                    visited[i] = True
                    result = dfs(n+1, words[i], result+1)
                    visited[i] = False
        return result
    
    answer = dfs(0, begin,0)
    return answer