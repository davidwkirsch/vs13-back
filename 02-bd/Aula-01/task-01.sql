create table VEM_SER.ESTUDANTE (
    id_estudante number,
    nome varchar2(200) NOT NULL,
    data_nascimento date NOT NULL,
    nr_matricula number NOT NULL UNIQUE,
    ativo varchar2(1) NOT NULL,
    CONSTRAINT estudante_pk PRIMARY KEY (id_estudante)
);

CREATE SEQUENCE SEQ_ESTUDANTE
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 
INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'David Kirsch', TO_DATE('01-01-1997', 'dd-mm-yyyy'), '0000000001', 'N');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Maicon Nunes', TO_DATE('02-02-1998', 'dd-mm-yyyy'), '0000000002', 'S');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Ana Maria', TO_DATE('03-03-1999', 'dd-mm-yyyy'), '0000000003', 'N');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Luana Santos', TO_DATE('04-04-1991', 'dd-mm-yyyy'), '0000000004', 'S');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'André Souza', TO_DATE('05-05-1992', 'dd-mm-yyyy'), '0000000005', 'N');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Pedro Castro', TO_DATE('06-06-1993', 'dd-mm-yyyy'), '0000000006', 'S');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Gabriel Alves', TO_DATE('07-07-1994', 'dd-mm-yyyy'), '0000000007', 'S');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Leonardo Schutz', TO_DATE('08-08-1995', 'dd-mm-yyyy'), '0000000008', 'N');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Sabrina Welter', TO_DATE('09-09-1996', 'dd-mm-yyyy'), '0000000009', 'S');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Yan Amaral', TO_DATE('10-10-1990', 'dd-mm-yyyy'), '0000000010', 'N');

SELECT * FROM VEM_SER.ESTUDANTE;