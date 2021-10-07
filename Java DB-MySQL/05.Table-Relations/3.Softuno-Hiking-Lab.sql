SELECT r.starting_point AS route_start_point,
r.end_point AS route_end_point,
r.leader_id, CONCAT_WS(' ', c.first_name, c.last_name)
FROM routes AS r
JOIN campers AS c
ON r.leader_id = c.id;