    create table shopping_items (
       id bigint not null auto_increment,
        name varchar(255) not null,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table users (
       id bigint not null auto_increment,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    alter table users
       drop index UK_r43af9ap4edm43mmtq01oddj6

    alter table users
       add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username)
    
    alter table shopping_items 
       add constraint FKtpkopyby8qwu1noj4n4t3yuig 
       foreign key (user_id) 
       references users (id)