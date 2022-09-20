create table customer
(
    email varchar(50) primary key,
    name varchar(50),
    dob date,
    gender number(1, 0),
    phone int,
    address varchar(100),
    district varchar(50),
    city varchar(50),
    pass varchar(100),
    active number(1, 0)
);

create table admin
(
    email varchar(50) primary key,
    role int,
    constraint fk_am_kh foreign key(email) references customer(email)
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
    description blob,
    spec blob,
    catid int,
    image varchar(100),
    rate float,
    discount float,
    adddate date,
    active number(1, 0),
    constraint fk_sp_tl foreign key (catid) references category(catid)
);

create table store
(
    storeid int primary key,
    city varchar(50),
    district varchar(50),
    email varchar(50) not null,
    constraint fk_ch_admin foreign key (email) references admin(email)
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
    email varchar(50) not null,
    stid int not null,
    payment varchar(50),
    address blob,
    note blob,
    rdate date,
    receiptstate varchar(50),
    constraint fk_dh_st foreign key (stid) references store(storeid),
    constraint fk_dh_kh foreign key (email) references customer(email)
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
    email varchar(50) not null,
    pid int not null,
    rating float,
    feedback blob,
    medialink varchar(100),
    fdate date,
    constraint fk_cm_sp foreign key (pid) references product(pid),
    constraint fk_cm_kh foreign key (email) references customer(email)
);

create table log
(
    logid int primary key,
    email varchar(50) not null,
    action varchar(10),
    affectedtable varchar(20),
    oldvalue blob,
    newvalue blob,
    changedate date
);
