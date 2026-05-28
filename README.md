# EatEase-Server

## 项目简介

EatEase-Server 是“食堂效率优化系统”的后端服务，基于 Spring Boot 2.x 构建。该系统旨在解决高校学生就餐排队久、找座难的问题，通过**预约点餐**、**时段饱和度预测**、**团体就餐桌数计算**等功能，实现学生提前点餐、到店即取，食堂商家高效接单、智能管理。

**核心亮点**：
- 预约即占座，时段饱和度实时展示
- 团体就餐桌数自动计算与冲突检测
- 基于用户偏好的菜品个性化推荐
- 商家端 WebSocket 实时新订单推送

## 技术栈

| 技术 | 版本 | 说明 |
|------|------|------|
| Java | 1.8+ | 后端开发语言 |
| Spring Boot | 2.7.0 | 核心框架 |
| MyBatis-Plus | 3.5.2 | ORM 框架 |
| MySQL | 8.0+ | 关系型数据库 |
| Redis | 6.x | 缓存（可选，用于时段饱和度缓存） |
| WebSocket | Spring Boot Starter | 商家端实时推送 |
| Maven | 3.6+ | 项目构建与依赖管理 |

## 环境要求

- JDK 1.8 或更高版本
- Maven 3.6+
- MySQL 8.0+（已创建数据库 `eat_ease`）
- （可选）Redis 6.0+

## 快速开始

### 1. 克隆项目

```bash
git clone https://github.com/your-repo/EatEase-Server.git
cd EatEase-Server
