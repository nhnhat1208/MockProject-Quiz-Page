USE [master]
GO
/****** Object:  Database [MockSystem]    Script Date: 8/24/2021 3:17:39 PM ******/
CREATE DATABASE [MockSystem]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'MockSystem', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\MockSystem.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'MockSystem_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\MockSystem_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [MockSystem] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [MockSystem].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [MockSystem] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [MockSystem] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [MockSystem] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [MockSystem] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [MockSystem] SET ARITHABORT OFF 
GO
ALTER DATABASE [MockSystem] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [MockSystem] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [MockSystem] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [MockSystem] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [MockSystem] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [MockSystem] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [MockSystem] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [MockSystem] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [MockSystem] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [MockSystem] SET  ENABLE_BROKER 
GO
ALTER DATABASE [MockSystem] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [MockSystem] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [MockSystem] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [MockSystem] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [MockSystem] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [MockSystem] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [MockSystem] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [MockSystem] SET RECOVERY FULL 
GO
ALTER DATABASE [MockSystem] SET  MULTI_USER 
GO
ALTER DATABASE [MockSystem] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [MockSystem] SET DB_CHAINING OFF 
GO
ALTER DATABASE [MockSystem] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [MockSystem] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [MockSystem] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [MockSystem] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'MockSystem', N'ON'
GO
ALTER DATABASE [MockSystem] SET QUERY_STORE = OFF
GO
USE [MockSystem]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 8/24/2021 3:17:39 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[username] [varchar](20) NOT NULL,
	[password] [varchar](20) NOT NULL,
	[dateBirth] [varchar](20),
	[email] [varchar](40) NULL,
	[job] [varchar](40) NULL,
	[role] [tinyint] NULL,
	[image] [text] NULL,
PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 8/24/2021 3:17:39 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](40) NOT NULL,
	[description] [text] NULL,
	[img_src] [text] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Quiz]    Script Date: 8/24/2021 3:17:39 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Quiz](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[test_id] [int] NOT NULL,
	[question] [text] NULL,
	[correctAnsw] [text] NULL,
	[incorrectAnsw_1] [text] NULL,
	[incorrectAnsw_2] [text] NULL,
	[incorrectAnsw_3] [text] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Score]    Script Date: 8/24/2021 3:17:39 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Score](
	[username] [varchar](20) NOT NULL,
	[test_id] [int] NOT NULL,
	[attemp] [int] NOT NULL,
	[score] [int] NULL,
	[numsCorrectperTotal] [varchar](20) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Test]    Script Date: 8/24/2021 3:17:39 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Test](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[topic] [varchar](20) NOT NULL,
	[name] [varchar](20) NOT NULL,
	[category_id] [int] NOT NULL,
	[username] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Account] ([username], [password], [email], [job], [role]) VALUES (N'admin1', N'admin', N'admin1@email.com', N'Admin', 0)
INSERT [dbo].[Account] ([username], [password], [email], [job], [role]) VALUES (N'admin2', N'admin', N'admin2@email.com', N'Admin', 0)
INSERT [dbo].[Account] ([username], [password], [email], [job], [role]) VALUES (N'admin3', N'admin', N'admin3@email.com', N'Admin', 0)
INSERT [dbo].[Account] ([username], [password], [email], [job], [role]) VALUES (N'user1', N'user', N'user1@email.com', N'Student', 1)
GO
SET IDENTITY_INSERT [dbo].[Category] ON 

INSERT [dbo].[Category] ([id], [name], [description], [img_src]) VALUES (1, N'C++', N'About C++', N'https://google.com.vn/')
INSERT [dbo].[Category] ([id], [name], [description], [img_src]) VALUES (2, N'Java', N'About Java', N'https://google.com.vn/')
INSERT [dbo].[Category] ([id], [name], [description], [img_src]) VALUES (3, N'Python', N'About Python', N'https://google.com.vn/')
SET IDENTITY_INSERT [dbo].[Category] OFF
GO
SET IDENTITY_INSERT [dbo].[Quiz] ON 

INSERT [dbo].[Quiz] ([id], [test_id], [question], [correctAnsw], [incorrectAnsw_1], [incorrectAnsw_2], [incorrectAnsw_3]) VALUES (1, 1, N'C++ la gi?', N'Ngon ngu lap trinh', N'Ngon ngu danh dau van ban', N'1 ky hieu', N'Tat ca deu sai')
SET IDENTITY_INSERT [dbo].[Quiz] OFF
GO
INSERT [dbo].[Score] ([username], [test_id], [attemp], [score], [numsCorrectperTotal]) VALUES (N'user1', 1, 1, 100, N'10/10')
GO
SET IDENTITY_INSERT [dbo].[Test] ON 

INSERT [dbo].[Test] ([id], [name], [category_id], [username]) VALUES (1, N'C++ Test', 1, N'admin1')
SET IDENTITY_INSERT [dbo].[Test] OFF
GO
ALTER TABLE [dbo].[Quiz]  WITH CHECK ADD  CONSTRAINT [fk_quiz_test_id] FOREIGN KEY([test_id])
REFERENCES [dbo].[Test] ([id])
GO
ALTER TABLE [dbo].[Quiz] CHECK CONSTRAINT [fk_quiz_test_id]
GO
ALTER TABLE [dbo].[Score]  WITH CHECK ADD  CONSTRAINT [fk_score_test_id] FOREIGN KEY([test_id])
REFERENCES [dbo].[Test] ([id])
GO
ALTER TABLE [dbo].[Score] CHECK CONSTRAINT [fk_score_test_id]
GO
ALTER TABLE [dbo].[Score]  WITH CHECK ADD  CONSTRAINT [fk_score_username] FOREIGN KEY([username])
REFERENCES [dbo].[Account] ([username])
GO
ALTER TABLE [dbo].[Score] CHECK CONSTRAINT [fk_score_username]
GO
ALTER TABLE [dbo].[Test]  WITH CHECK ADD  CONSTRAINT [fk_test_category_id] FOREIGN KEY([category_id])
REFERENCES [dbo].[Category] ([id])
GO
ALTER TABLE [dbo].[Test] CHECK CONSTRAINT [fk_test_category_id]
GO
USE [master]
GO
ALTER DATABASE [MockSystem] SET  READ_WRITE 
GO



/* data cho main page vs admin page */ 
INSERT INTO [dbo].[Account] ([username], [password], [dateBirth], [email], [job], [role]) VALUES ('hhnam','12345','2000-11-15','nam.huynh1813136@hcmut.edu.vn','Student',1);
DELETE FROM [dbo].[Account] WHERE [username] = 'hhnam';

INSERT [dbo].[Score] ([username], [test_id], [attemp], [score], [numsCorrectperTotal]) VALUES (N'hhnam', 2, 1, 100, N'10/10')
INSERT [dbo].[Score] ([username], [test_id], [attemp], [score], [numsCorrectperTotal]) VALUES (N'hhnam', 3, 1, 100, N'8/10')
DELETE FROM [dbo].Score WHERE [username] = 'hhnam';
GO

SET IDENTITY_INSERT [dbo].[Test] ON 
INSERT [dbo].[Test] ([id], [topic] ,[name], [category_id], [username]) VALUES (2,'topic 1', N'C++ Test', 1, N'hhnam')
INSERT [dbo].[Test] ([id], [topic] ,[name], [category_id], [username]) VALUES (3,'topic 2', N'Java Test', 2, N'hhnam')
INSERT [dbo].[Test] ([id], [topic] ,[name], [category_id], [username]) VALUES (4,'topic 3', N'Java Test', 2, N'admin')
INSERT [dbo].[Test] ([id], [topic] ,[name], [category_id], [username]) VALUES (5,'topic 4', N'Python Test', 3, N'admin2')
INSERT [dbo].[Test] ([id], [topic] ,[name], [category_id], [username]) VALUES (6,'topic 5', N'C# Test', 4, N'admin2')
DELETE FROM [dbo].Test WHERE [username] = 'hhnam';
SET IDENTITY_INSERT [dbo].[Test] OFF
GO
