CREATE TABLE Role (
                      RoleID INT PRIMARY KEY,
                      RoleName NVARCHAR(1000) NOT NULL,
                      Description NVARCHAR(1000)
);

CREATE TABLE G_User (
                        UserID INT PRIMARY KEY,
                        UserType NVARCHAR(50),
                        Name NVARCHAR(100),
                        Email NVARCHAR(100),
                        Password NVARCHAR(100),
                        UniversityID NVARCHAR(50),
                        CreatedAt DATETIME,
                        RoleID INT,
                        CONSTRAINT FK_Users_Role FOREIGN KEY (RoleID) REFERENCES Role(RoleID)
);
CREATE TABLE Category (
                          CategoryID INT PRIMARY KEY,
                          CategoryName NVARCHAR(1000),
                          Description NVARCHAR(1000)
);

-- جدول المشاريع PROJECT
CREATE TABLE PROJECT (
                         ProjectID INT PRIMARY KEY,
                         CreatorID INT,
                         SupervisorID INT,
                         CategoryID INT,
                         Title NVARCHAR(1000),
                         Status NVARCHAR(1000),
                         CreationDate DATETIME,
                         IsDeleted bit,
                         CONSTRAINT FK_PROJECT_Creator FOREIGN KEY (CreatorID) REFERENCES G_User(UserID),
                         CONSTRAINT FK_PROJECT_Supervisor FOREIGN KEY (SupervisorID) REFERENCES G_User(UserID),
                         CONSTRAINT FK_PROJECT_Category FOREIGN KEY (CategoryID) REFERENCES Category(CategoryID)
);

-- جدول التصنيفات Categories


-- جدول المجموعات Groups
CREATE TABLE G_Group (
                         GroupID INT PRIMARY KEY,
                         ProjectID INT,
                         GroupName NVARCHAR(100),
                         CreatedBy INT,
                         CreationDate DATETIME,
                         CONSTRAINT FK_Groups_Project FOREIGN KEY (ProjectID) REFERENCES Project(ProjectID),
                         CONSTRAINT FK_Groups_CreatedBy FOREIGN KEY (CreatedBy) REFERENCES G_User(UserID)
);

-- أعضاء المجموعات Group_Members
CREATE TABLE Group_Member (
                              GroupMemberID INT PRIMARY KEY,
                              GroupID INT,
                              UserID INT,
                              Role NVARCHAR(1000),
                              JoinDate DATETIME,
                              CONSTRAINT FK_GroupMembers_Group FOREIGN KEY (GroupID) REFERENCES G_Group(GroupID),
                              CONSTRAINT FK_GroupMembers_User FOREIGN KEY (UserID) REFERENCES G_User(UserID)
);

-- جدول الرسائل Messages
CREATE TABLE Message (
                         MessageID INT PRIMARY KEY,
                         SenderID INT,
                         ReceiverID INT,
                         ProjectID INT,
                         Message NVARCHAR(1000),
                         SentDate DATETIME,
                         IsRead bit,
                         CONSTRAINT FK_Messages_Sender FOREIGN KEY (SenderID) REFERENCES G_User(UserID),
                         CONSTRAINT FK_Messages_Receiver FOREIGN KEY (ReceiverID) REFERENCES G_User(UserID),
                         CONSTRAINT FK_Messages_Project FOREIGN KEY (ProjectID) REFERENCES Project(ProjectID)
);

-- جدول الوثائق Documents
CREATE TABLE Document (
                          DocumentID INT PRIMARY KEY,
                          ProjectID INT,
                          UploaderID INT,
                          Title NVARCHAR(1000),
                          FileType NVARCHAR(1000),
                          FileURL NVARCHAR(1000),
                          UploadDate DATETIME,
                          IsPublic bit,
                          CONSTRAINT FK_Documents_Project FOREIGN KEY (ProjectID) REFERENCES Project(ProjectID),
                          CONSTRAINT FK_Documents_Uploader FOREIGN KEY (UploaderID) REFERENCES G_User(UserID)
);
-- جدول التقييمات Ratings
CREATE TABLE Rating (
                        RatingID INT PRIMARY KEY,
                        ProjectID INT,
                        UserID INT,
                        Review NVARCHAR(1000),
                        RatingDate DATETIME,
                        CONSTRAINT FK_Ratings_Project FOREIGN KEY (ProjectID) REFERENCES Project(ProjectID),
                        CONSTRAINT FK_Ratings_User FOREIGN KEY (UserID) REFERENCES G_User(UserID)
);