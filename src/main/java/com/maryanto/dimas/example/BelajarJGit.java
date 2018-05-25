package com.maryanto.dimas.example;

import org.eclipse.jgit.api.AddCommand;
import org.eclipse.jgit.api.CommitCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

import java.io.File;
import java.io.IOException;

public class BelajarJGit {

    public static void main(String[] args) throws IOException, GitAPIException {
        String gitRepository = new StringBuilder(System.getProperty("user.home"))
                .append(File.separator).append("default").append(File.separator).append("test").append(File.separator).append(".git").toString();
        FileRepositoryBuilder builder = new FileRepositoryBuilder();
        Repository repository = builder.setGitDir(new File(gitRepository))
                .readEnvironment() // scan environment GIT_* variables
                .findGitDir() // scan up the file system tree
                .build();
        System.out.println(repository.getBranch());

        Git git = new Git(repository);
        AddCommand add = git.add();
        add.addFilepattern(".").call();

        CommitCommand commitComand = git.commit();
        commitComand.setMessage("Add and object").call();
    }
}
