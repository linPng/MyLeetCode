# 统计词频 中等 不会
cat words.txt |tr -s ' ' '\n' |sort|uniq -c|sort -r|awk '{print $2,$1}'

1、首先cat命令查看words.txt
2、tr -s ' ' '\n'将空格都替换为换行 实现分词
3、sort排序 将分好的词按照顺序排序
4、uniq -c 统计重复次数（此步骤与上一步息息相关，-c原理是字符串相同则加一，如果不进行先排序的话将无法统计数目）
5、sort -r 将数目倒序排列
6、awk '{print $2,$1}' 将词频和词语调换位置打印出来
