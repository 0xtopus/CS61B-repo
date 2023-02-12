# git配置

`git config --global user.name "..."`

`git config --global user.email"..."`

# 使用git

`git status`: 查看当前目录的文件状态

`git init` :初始化仓库

# 文件状态

- 未跟踪

- 已跟踪

  - 暂存：文件已修改且保存，但还没有提交到git仓库
  - 未修改
  - 已修改

  

  刚刚添加到仓库的文件是未跟踪状态。

  `git add 文件名` ：将文件从**未跟踪**切换到**暂存**的状态

  `git add *`：将所有已修改 (未跟踪) 的文件暂存

  `git add -A`：把所有的变化（包括删除的和添加的文件）暂存

  `git commit -m "<message>" `：将**暂存**的文件存到仓库里, message是本次提交的日志信息，状态变成 **未修改**

  `git commit -a -m "<message>"`:提交所有已修改的文件
  
  文件发生变化时，变成**已修改**的状态

​		`git log`：查看历次提交的记录

可以在vscode里使用图形化界面git

# 常用命令

1. 重置文件

```bash
git restore <filename> 
#修改后，还未暂存时，可以用来恢复文件

git restore --stage <filename> #取消暂存状态，不会取消删除的文件
```

如果要取回被删的文件，还要再restore一下



2. 恢复某版本的某文件

   ```bash
   git checkout 9f955d85359fc8e4504d7220f13fad34f8f2c62b ./recipes/tofu
   ```

   - 恢复版本`9f955d85359fc8e4504d7220f13fad34f8f2c62b`的文件`./recipes/tofu`
   - 注意，`checkout`命令不会改变提交记录，且必须==指定要恢复的文件名==，否则会出现bug（如遇此种情况，见：[Git WTFs](https://sp18.datastructur.es/materials/guides/git-wtfs.html)）
   - 回滚之后，需要再`commit`一次。

3. 删除文件

```bash
git rm <filename>
git rm -f <filename> #强制删除
```

3. 移动文件（重命名）

```bash
git mv from to #移动文件/重命名文件
```

# 分支

git在commit文件时，每次都会创建一个节点，记录代码的状态。

节点会构成一个树状结构，存在分支。

默认情况下，只有一个分支，叫做 "master"

```bash
git branch #查看当前分支
git branch <branch name> #新建一个分支
git branch -D <branch name> #删除分支
git switch <branch name>	#切换分支
git switch -c <branch name> #创建并切换分支
```

在开发中，都是在自己的分支里写代码。写好无误后，再合并分支。

- 合并分支

```bash
git switch master	#切换到主分支
git merge <branch name> #合并分支
git branch -D <branch name> #合并之后可以删除不需要的分支
```



在装了插件的VScode里面的COMMIT DETAILS里，可以通过graph来查看所有分支的情况

<img src=".\note_pics\gitPics\image-20221219172950437.png" alt="image-20221219172950437" style="zoom:50%;" />

有的时候，分支可以快速合并（fast-forward)，但有时候，合并时分支的文件之间会产生冲突。git会帮助你标识出冲突所在，这时候需要手动合并，然后暂存和提交：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>wawawa</h1>
<<<<<<< HEAD
    <h2>bugbug fixfix</h2>
=======
    <h1>jjj</h1>
    <h1>wuwuwu</h1>
    <ul>
        <li>wiwdiu</li>
    </ul>
>>>>>>> test
</body>
</html>
```

# 变基(rebase)

当开发分支较多时，merge会把分支树变得很乱。此时可以使用变基来合并分支。

注意：变基操作一般只在自己的本地仓库使用，远程服务器的仓库不可以使用变基。

1. 发起变基时，git会先找到两条最近分支的最近祖先	
2. 把当前分支和合并分支的共同祖先进行比对，把所有的变化提取出来存到一个临时文件里
3. 将当前分支的祖先指向目标分支的基底
4. 从当前基底开始重新执行之前临时存起来的操作

```bash
git switch <filename>
git rebase <target filename>
```



# tag标签

- 分离头指针：

```bash
git switch <commit id> --detach   #commit id可以只写前几位
```

把头指针移动到早期创建的某个节点上。注意：==此时只能预览，不可以修改和提交代码。==



- 如果要在早期的节点上进行修改，请在该早期节点上==创建新分支==：

```bash
git switch -c <new branch name> <commit id>
```



但是，如果版本很多，找到某个特定的节点很困难。使用**标签**来给特定的节点做记号。

- 标签

```bash
git tag #显示当前节点的所有标签
git tag <tag name> #给当前节点添加一个标签 比如 v1.0
git tag <tag name> <cmt id> #给某个节点添加标签

#使用标签来操作：
git push <remote> <tag name> #给远程仓库的版本加标签(推送本地标签到远程仓库)
git push <remote> --tags #推送所有本地标签
git -d <tag name> #删除本地标签
git push <remote> --delete <tagname> #删除远程仓库的标签
```

之后，我们就可以通过标签来快速之前的定位节点，创建新分支了。

```bash
git switch -c <tag name>
```



# 远程仓库(remote)

- GitHub
- Gitee

上传到github：

```bash
git remote add origin https://github.com/lilichao/git-demo.git
# git remote add <remote name> <url>

git branch -M main
# 修改分支的名字的为main

git push -u origin main
# git push 将代码上传服务器上
```



## 远程库的操作的命令

```bash
git remote # 列出当前的关联的远程库
git remote add <远程库名> <url> # 关联远程仓库
git remote remove <远程库名>  # 删除远程库

git push -u <远程库名> <分支名> # 向远程库推送代码，并和当前分支关联
git push <远程库> <本地分支>:<远程分支> #推送到指定的远程分支

git clone <url> # 从远程库下载代码
git clone <url> <new filename># 从远程库下载代码,并重命名

git push # 如果本地的版本低于远程库，push默认是推不上去
git fetch # 要想推送成功，必须先确保本地库和远程库的版本一致，fetch它会从远程仓库下载所有代码，但是它不会将代码和当前分支自动合并
		 # 使用fetch拉取代码后，必须要手动对代码进行合并
git merge origin/master #手动合并
git pull  # 从服务器上拉取代码并自动合并 
```

==注意：==

==1. 推送代码之前，一定要先从远程库中拉取最新的代码==

==2. 写自己的代码前，一定要创建新分支==



## origin/main/master

来源：https://blog.csdn.net/reykou/article/details/104866348

1. GIT 初始化：本地默认分支叫 master、服务器默认名为 origin。本地分支 master 同步到服务器上、服务器节点变成 orgin/master
2. 本地创建分支名为 branch，本地分支 branch 同步到服务器上、服务器节点变成 orgin/branch
3. 更新本地分支 master，用本地分支 master 更新服务器节点 orgin/master



## git代理的设置

远程库连接很缓慢，那么，我们可以通过配置代理来解决这个问题。

首先查看你的代理软件的相关设置，搞清楚你代理使用的本地socks端口：

<img src="F:\awsl\Java\cs61b\AceMyFile\note_pics\gitPics\socksPort.png" style="zoom:100%;" />

```bash
git config --global https.proxy http://127.0.0.1:10808  #设置为你自己的端口，比如我的是10808

git config --global https.proxy https://127.0.0.1:10808

git config --global --unset http.proxy

git config --global --unset https.proxy
```

参考：https://gist.github.com/laispace/666dd7b27e9116faece6



## 远程库解决push授权问题

配置完代理，可能会引发如下问题：

```bash
Administrator@USER-20160428EL MINGW64 /f/awsl/Java/cs61b/AceMyFile (master)
$ git push origin master
fatal: NotSupportedException encountered.
   The ServicePointManager does not support proxies with the socks5h scheme.
error: unable to read askpass response from 'E:/git/Git/mingw64/libexec/git-core/git-gui--askpass'
Username for 'https://github.com': xxxx
remote: Support for password authentication was removed on August 13, 2021.
remote: Please see https://docs.github.com/en/get-started/getting-started-with-git/about-remote-repositories#cloning-with-https-urls for information on currently recommended modes of authentication.
fatal: Authentication failed for 'https://github.com/xxxx/xxxx.git/'

```

如果用VSCode推送好像可以绕开这个问题。

但是，如果使用命令行来推送：



## GitHub添加/删除关联的远程仓库

参考：https://blog.csdn.net/ltstud/article/details/79935001

```bash
git remote add <远程仓库名> <本地库名>
git remote rm <远程仓库名> 
```



# gitignore

- 默认情况下，git会监视项目里所有的文件。但是有时候，不是所有的文件都需要被git监视。
- 使用 *gitignore* 来让git忽略它们
- 在项目目录里新建一个 `.gitignore` 文件，把要忽略的文件名输入进去

```
#注释
node_modules
yarn.lock
*.log
```



## git ignore 配置

1. 使用`!<filename>`来使git不忽略某个文件。比如你需要git不忽略某个叫做`MyFile`的文件夹下的所有文件，在`.gitignore`里你可以这样写：

   ```txt
   !MyFile/*
   ```

   

2. 



# 查看git配置

```bash
git config <配置名> #查看某个配置情况
```

更多配置：https://www.atlassian.com/zh/git/tutorials/setting-up-a-repository/git-config



# GitHub 只添加已追踪的文件

```bash
git add -u
```

ref: https://www.google.com/search?q=how+to+add+tracked+files+only+in+git&oq=how+to+add+tracked+files+only+in&aqs=chrome.1.69i57j33i10i160l3.16226j0j9&sourceid=chrome&ie=UTF-8

使用前：
```bash
Administrator@USER-20160428EL MINGW64 /f/awsl/Java/cs61b (master)
$ git status
On branch master
Your branch is ahead of 'origin/master' by 2 commits.
  (use "git push" to publish your local commits)

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   lab2/DebugPractice/DebugExercise1.java
        modified:   lab2/DebugPractice/DebugExercise2.java
        modified:   lab2/Intlist/IntList.java

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        lab2/.idea/
        lab2setup/.idea/
        lab2setup/out/

no changes added to commit (use "git add" and/or "git commit -a")
```

使用：
```bash
Administrator@USER-20160428EL MINGW64 /f/awsl/Java/cs61b (master)
$ git add -u
```

使用后：
```bash
Administrator@USER-20160428EL MINGW64 /f/awsl/Java/cs61b (master)
$ git status
On branch master
Your branch is ahead of 'origin/master' by 2 commits.
  (use "git push" to publish your local commits)

Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        modified:   lab2/DebugPractice/DebugExercise1.java
        modified:   lab2/DebugPractice/DebugExercise2.java
        modified:   lab2/Intlist/IntList.java

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        lab2/.idea/
        lab2setup/.idea/
        lab2setup/out/

```



# Github ICU

远程仓库和本地仓库出现较大混乱时，可以这样恢复到希望回到的之前的某个commit版本。

首先，进入你的本地仓库，使用`git log`命令找到你希望退回的**commit版本号**，然后使用：

```bash
git reset --hard <commit>
```

回到你希望的commit版本。但是，在使用之前，==你最好将文件进行备份==，以免reset到错误的版本后丢失数据。

你也可以使用`git reflog`来查看之前的操作，并且可以通过`git reflog`里提供的commit版本号来再次使用`reset --hard`命令回溯到操作前所在的commit版本（可以作为reset错误后的后悔药！）

然后，对远程仓库使用强行同步更新：

```bash
git push -f 
```

[^参考1]:  https://stackoverflow.com/questions/42860234/how-to-undo-a-merge-in-github，Stack Overflow的相关回答。
[^参考2]:  https://initialcommit.com/blog/git-reset，对reset的详细讲解
[^参考3]:https://stackoverflow.com/questions/495345/how-to-remove-selected-commit-log-entries-from-a-git-repository-while-keeping-th，Stack Overflow.
[^参考4]: https://stackoverflow.com/questions/4114095/how-do-i-revert-a-git-repository-to-a-previous-commit，Stack Overflow上的一个比较详细的高赞回答，不过我没细看...
[^参考5]: https://stackoverflow.com/questions/29042783/how-can-i-delete-all-commits-before-a-given-date-in-git-history，Stack Overflow：how can I delete all commits before a given date in git history.



```bash
Administrator@USER-20160428EL MINGW64 /f/awsl/Java/cs61b (master)
$ git log
commit cca2edf5fbf99d5295cca7c0c56c807f0e2194ab (HEAD -> master, origin/master, origin/HEAD)
Author: cyber_octopus <gsy@gsy123mailbox.com>
Date:   Sat Feb 11 17:00:26 2023 +0800

    reset files

commit ad9c8610ec1d326fa88c7a8088ae53b4fe6fff5c
Author: cyber_octopus <gsy@gsy123mailbox.com>
Date:   Fri Feb 10 11:06:37 2023 +0800

    fix the bug of IntList.java*

commit c0ae005a84005d9f528673b36ca4507386ac711c
Author: cyber_octopus <gsy@gsy123mailbox.com>
Date:   Thu Feb 9 23:02:06 2023 +0800

    add IntList.java with a small bug which would count one less size of the IntList and also modify my note a bit

commit 3bae4aa49e997c62db531f53c6427ea510f90942
Author: cyber_octopus <gsy@gsy123mailbox.com>
Date:   Wed Feb 8 22:26:27 2023 +0800

    add .gitignore, SumArg.java and modify my note

commit 4f461e2ca33d4d7e878011305dd401d91209f13e
Author: cyber_octopus <gsy@gsy123mailbox.com>
Date:   Sat Feb 4 23:26:25 2023 +0800

    create new README file and tweak my first week  java note

commit 14f93eae87f460eebf10617cbb650d2ca0af8c57
Author: cyber_octopus <gsy@gsy123mailbox.com>
Date:   Sat Feb 4 23:20:55 2023 +0800

    finish the first week task

commit 5551fe36d65a915e35b7af01beb615cf596d9902
Author: cyber_octopus <gsy@gsy123mailbox.com>
Date:   Sat Feb 4 21:47:51 2023 +0800

    commit first week's stuff


Administrator@USER-20160428EL MINGW64 /f/awsl/Java/cs61b (master)
$ git reflog
cca2edf (HEAD -> master, origin/master, origin/HEAD) HEAD@{0}: commit: reset files
ad9c861 HEAD@{1}: reset: moving to ad9c8610
a09fb44 HEAD@{2}: checkout: moving from master to master
a09fb44 HEAD@{3}: pull --allow-unrelated-histories: Merge made by the 'recursive' strategy.
7ef79fc HEAD@{4}: rebase finished: returning to refs/heads/master
7ef79fc HEAD@{5}: rebase: delete all skeleton files
4f0a62f HEAD@{6}: rebase: delete all skeleton file and try to set up again
0515c34 HEAD@{7}: rebase: lab1 ready to submit
a3610f2 HEAD@{8}: rebase: add all files from official repo of cs61b
ad9c861 HEAD@{9}: rebase: fix the bug of IntList.java*
c0ae005 HEAD@{10}: rebase: add IntList.java with a small bug which would count one less size of the IntList and also modify my note a bit
3bae4aa HEAD@{11}: rebase: add .gitignore, SumArg.java and modify my note
4f461e2 HEAD@{12}: pull --rebase --allow-unrelated-histories skeleton master: create new README file and tweak my first week java note
14f93ea HEAD@{13}: pull --rebase --allow-unrelated-histories skeleton master: finish the first week task
5551fe3 HEAD@{14}: pull --rebase --allow-unrelated-histories skeleton master: commit first week's stuff
fa6b0b8 (skeleton/master) HEAD@{15}: pull --rebase --allow-unrelated-histories skeleton master: checkout fa6b0b8a7f1d83bf1aa47b9182bce4cad238f14e

Administrator@USER-20160428EL MINGW64 /f/awsl/Java/cs61b (master)
$ git reset 7ef79fc

```







# GitHub大量删除和添加文档后批量暂存

参考：https://blog.csdn.net/haohaibo031113/article/details/70821321

```bash
git add -A  # GitHub大量删除和添加文档后批量暂存，也可以用 rm 命令来处理删除的文件
```



# GitHub重命名远程仓库

```bash
git branch -M main #把当前master分支改名为main, 其中-M的意思是移动或者重命名当前分支
```

参考：https://juejin.cn/post/7051873701305778207



# 小技巧

1. 在命令行模式下，在要打开的目录里输入：

```bash
code .
```

即可用vscode打开当前目录

# 深入研究

https://git-scm.com/book/en/v2

# GitHub部署静态页面

待填