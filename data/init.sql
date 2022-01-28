CREATE TABLE casos_full (
	city text,
	city_ibge_code integer,
	date_info date,
	epidemiological_week integer,
	estimated_population integer,
	estimated_population_2019 integer,
	is_last boolean,
	is_repeated boolean,
	last_available_confirmed integer,
	last_available_confirmed_per_100k_inhabitants double precision,
	last_available_date date,
	last_available_death_rate double precision,
	last_available_deaths integer,
	order_for_place integer,
	place_type text,
	state_info text,
	new_confirmed integer,
	new_deaths integer
);