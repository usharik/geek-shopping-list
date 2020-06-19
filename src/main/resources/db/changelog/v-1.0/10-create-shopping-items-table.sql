create table shopping_items (
   id bigint not null auto_increment,
    name varchar(255) not null,
    user_id bigint,
    primary key (id)
) engine=InnoDB

GO

alter table shopping_items
   add constraint FKtpkopyby8qwu1noj4n4t3yuig
   foreign key (user_id)
   references users (id)
GO
