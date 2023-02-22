//9th-prblm
def knightProbability(self, N: int, K: int, r: int, c: int) -> float:
	"""
	BFS, use a set to track the nodes in a tree remaining in the board in each step
	Time: O(8 * N ^ 2 * K)
	Space: O(N ^ 2)
	"""
	q = {(r, c): 1}
	level = 0
	directions = {(dx, dy) for dx in (-2, -1, 1, 2) for dy in (-2, -1, 1, 2) if abs(dx) + abs(dy) == 3}
	is_in_board = lambda r, c: 0 <= r < N and 0 <= c < N
	while level < K and q:
		next_q = collections.defaultdict(int)
		for coord, count in q.items():
			x, y = coord
			for dx, dy in directions:
				if is_in_board(x + dx, y + dy):
					next_q[(x + dx, y + dy)] += count
		q = next_q
		level += 1
		# print(f'Level {level}: {q}')

	return sum(q.values()) / 8 ** K
