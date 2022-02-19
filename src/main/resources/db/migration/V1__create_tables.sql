create table if not exists subscribers
(
    subscriber_id bigserial PRIMARY KEY,
    tariff_id bigint,
    device_id bigint,
    first_name varchar(255),
    last_name varchar(255),
    date_of_birth date,
    phone_number varchar(255),
    count_of_messages int,
    count_of_calls int,
    count_of_internet_surfing int,
    all_activity int
);



create table if not exists tariffs
(
    tariff_id bigserial PRIMARY KEY,
    price int,
    dtype varchar(31) not null
);

create table if not exists messages
(
    message_id bigserial PRIMARY KEY,
    sender_id bigint,
    receiver_id bigint,
    text varchar(255)
);

create table if not exists devices
(
    device_id bigserial PRIMARY KEY,
    device_name varchar(255)
)