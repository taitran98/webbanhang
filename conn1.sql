create table customer
(
    id int primary key,
    name varchar(50),
    pass varchar(50),
    dob date,
    gender number(1, 0),
    address varchar(100),
    district varchar(50),
    city varchar(50),
    email varchar(50),
    phone int,
    active number(1, 0)
);

create table admin
(
    id int primary key,
    role int,
    foreign key(id) references customer(id)
);

create table category
(
    catid int primary key,
    catname varchar(50)
);

create table product
(
    pid int primary key,
    pname varchar(50),
    price int,
    spec blob,
    catid int,
    image varchar(100),
    descriptopn blob,
    rate float,
    discount float,
    active number(1, 0),
    adddate date,
    constraint fk_sp_tl foreign key (catid) references category(catid)
);

create table store
(
    storeid int primary key,
    city varchar(50),
    district varchar(50),
    adminid int not null,
    constraint fk_ch_admin foreign key (adminid) references admin(id)
);

create table inventory
(
    pid int,
    stid int,
    invennum int,
    primary key(pid, stid),
    constraint fk_ton_sp foreign key (pid) references product(pid),
    constraint fk_ton_ch foreign key (stid) references store(storeid)
);

create table receipt
(
    rid int primary key,
    cid int not null,
    stid int not null,
    payment varchar(50),
    note blob,
    address blob,
    rdate date,
    receiptstate varchar(50)
    constraint fk_dh_nd foreign key (cid) references customer(id),
    constraint fk_dh_st foreign key (stid) references store(storeid)
);

create table receiptlist
(
    pid int not null,
    rid int not null,
    num int,
    total int,
    primary key(pid, rid),
    constraint fk_ct_sp foreign key (pid) references product(pid),
    constraint fk_ct_dh foreign key (rid) references receipt(rid)
);

create table feedback
(
    fid int primary key,
    cid int not null,
    pid int not null,
    rating float,
    feedback blob,
    medialink varchar(100),
    fdate date,
    constraint fk_cm_nd foreign key (cid) references customer(id),
    constraint fk_cm_sp foreign key (pid) references product(pid)
);

create table log
(
    logid int primary key,
    adminid int not null,
    action varchar(10),
    affectedtable varchar(20),
    oldvalue blob,
    newvalue blob,
    changedate date
);

insert into theloai values (4, '?i?n tho?i');
insert into theloai values (3, 'tablet');

select * from tmpuser;

alter table product 
rename column descriptopn to shortsummary

alter table product
add adddate date


