-- Database 생성
CREATE DATABASE TEST_DB
    DEFAULT CHARACTER SET UTF8;

-- 사용자 생성
CREATE USER test_user@localhost
    IDENTIFIED BY 'admin';

-- DB 권한 부여
GRANT ALL PRIVILEGES
    ON TEST_DB.*
    TO test_user@localhost;
