package com.example.smokingcessation.config;

import com.example.smokingcessation.model.*;
import com.example.smokingcessation.repo.*;
import com.example.smokingcessation.security.MD5Utils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunnerUser(CigaretteRepository cigaretteRepository, SmokingRecordRepository smokingRecordRepository, UserRepository userRepository, PostRepository postRepository, CommentRepository commentRepository){
        return args -> {
            ArrayList<Cigarette> cigarettes = new ArrayList<>();

            BufferedReader br = new BufferedReader(
                    new FileReader("src/main/java/com/example/smokingcessation/CigarettePrices.txt"));

            String line = br.readLine();
            while(line!=null){
                String[] split = line.split(",");
                cigarettes.add(new Cigarette(split[0],Double.parseDouble(split[1])));
                line = br.readLine();
            }
            List<Cigarette> savedCigarettes = cigaretteRepository.saveAll(cigarettes);

            ArrayList<User> users = new ArrayList<>();

            users.add(
                    new User("jeman",
                            MD5Utils.hash("password"),
                            "Marawi",
                            getByteArray("startPics/jeman.png"),
                            savedCigarettes.get(0))
            );
            users.add(
                    new User("albrent",
                            MD5Utils.hash("password"),
                            "Iligan",
                            getByteArray("startPics/albrent.png"),
                            savedCigarettes.get(0)));
            User genrev = new User("genrev",
                    MD5Utils.hash("password"),
                    "Ozamiz",
                    getByteArray("startPics/genrev.png"),
                    savedCigarettes.get(0));
            genrev.setStartingDate(LocalDateTime.of(1999,9,9,12,12,12));
            genrev.setStoppedSmokingDate(LocalDateTime.of(1999,9,9,12,12,12));
            users.add(genrev);
            List<User> savedUsers = userRepository.saveAll(users);

            //Jeman
            smokingRecordRepository.save(new SmokingRecord(savedUsers.get(0),savedCigarettes.get(2),9,LocalDateTime.of(2022,6,2,12,30)));

            //Albrent
            smokingRecordRepository.save(new SmokingRecord(savedUsers.get(1),savedCigarettes.get(2),9,LocalDateTime.of(2022,5,9,12,30)));
            smokingRecordRepository.save(new SmokingRecord(savedUsers.get(1),savedCigarettes.get(2),7,LocalDateTime.of(2022,5,10,12,30)));
            smokingRecordRepository.save(new SmokingRecord(savedUsers.get(1),savedCigarettes.get(2),7,LocalDateTime.of(2022,5,11,12,30)));
            smokingRecordRepository.save(new SmokingRecord(savedUsers.get(1),savedCigarettes.get(2),6,LocalDateTime.of(2022,5,12,12,30)));
            smokingRecordRepository.save(new SmokingRecord(savedUsers.get(1),savedCigarettes.get(2),4,LocalDateTime.of(2022,5,13,12,30)));


            //Genrev
            smokingRecordRepository.save(new SmokingRecord(savedUsers.get(2),savedCigarettes.get(0),5,LocalDateTime.of(2022,5,19,12,30)));
            smokingRecordRepository.save(new SmokingRecord(savedUsers.get(2),savedCigarettes.get(1),3,LocalDateTime.of(2022,5,20,12,30)));
            smokingRecordRepository.save(new SmokingRecord(savedUsers.get(2),savedCigarettes.get(0),9,LocalDateTime.of(2022,5,21,12,30)));
            smokingRecordRepository.save(new SmokingRecord(savedUsers.get(2),savedCigarettes.get(0),8,LocalDateTime.of(2022,5,22,12,30)));
            smokingRecordRepository.save(new SmokingRecord(savedUsers.get(2),savedCigarettes.get(1),8,LocalDateTime.of(2022,5,23,12,30)));
            smokingRecordRepository.save(new SmokingRecord(savedUsers.get(2),savedCigarettes.get(0),6,LocalDateTime.of(2022,5,24,12,30)));
            smokingRecordRepository.save(new SmokingRecord(savedUsers.get(2),savedCigarettes.get(0),4,LocalDateTime.of(2022,5,25,12,30)));
            smokingRecordRepository.save(new SmokingRecord(savedUsers.get(2),savedCigarettes.get(1),5,LocalDateTime.of(2022,5,26,12,30)));
            smokingRecordRepository.save(new SmokingRecord(savedUsers.get(2),savedCigarettes.get(1),5,LocalDateTime.of(2022,5,27,12,30)));
            smokingRecordRepository.save(new SmokingRecord(savedUsers.get(2),savedCigarettes.get(0),4,LocalDateTime.of(2022,5,28,12,30)));
            smokingRecordRepository.save(new SmokingRecord(savedUsers.get(2),savedCigarettes.get(0),3,LocalDateTime.of(2022,5,29,12,30)));
            smokingRecordRepository.save(new SmokingRecord(savedUsers.get(2),savedCigarettes.get(0),1,LocalDateTime.of(2022,5,30,12,30)));
            smokingRecordRepository.save(new SmokingRecord(savedUsers.get(2),savedCigarettes.get(0),3,LocalDateTime.of(2022,6,1,12,30)));
            smokingRecordRepository.save(new SmokingRecord(savedUsers.get(2),savedCigarettes.get(0),1,LocalDateTime.of(2022,6,2,12,30)));


            generatePost(postRepository,
                    commentRepository,
                    savedUsers,
                    "Former smokers",
                    "How did you quit?\n" +
                            "\n" +
                            "Hi. I'm pubinthetub and I'm a nicotine addict.\n" +
                            "\n" +
                            "I'm a really heavy smoker. It started in late 2005 so I've been hooked for almost 13 years.\n" +
                            "\n" +
                            "Aside from the health risks (which I'm constantly reminded of by every pack I buy - various types of cancer, emphysema, impotence gasp), sobrang gastos na rin kasi. When I started, a pack of Marlboro Lights was 35 pesos. Now, a pack costs 90+ pesos. 100+ pa sa iba. So you can imagine the expense. It all adds up.\n" +
                            "\n" +
                            "Thing is, I'm physically and psychologically addicted. Addicted ng malala. After waking up, I pee, drink a tall glass of water then smoke my first stick of the (usually long) day. I look forward to every break, every designated smoking area, every chance I can smoke. I also used to smoke while walking noong pwede pa magyosi kahit saan so most likely, I earned the ire of every nonsmoker I encountered.\n" +
                            "\n" +
                            "I've tried quitting countless times. I also fail everytime. The craving gets too intense and I find myself getting antsy with every second. When a craving hits, it doesn't go away. I'm like that with most things e (cigarettes, food, etc).\n" +
                            "\n" +
                            "So... pahingi namang tips o.",
                    "Hey. I know this might be something that you won't expect but maybe you should try to see a psychologist to help with your addiction. I think it'd be nice to get a professional perspective. I'm pretty sure they can help.\n" +
                            "\n" +
                            "Maybe you can also try to lessen your intake a day. If you're doing 6 sticks a day maybe try to do 5x a day then slowly cut the number per week (or whatever time frame suits you).\n" +
                            "\n" +
                            "I agree with the other commenter that you should try to carry candy/gums with you all the time, anything to munch on or anything that can substitute a cigarette stick. And yes, you might also want to get a new hobby/interest or anything that can keep your mind away from smoking.\n" +
                            "\n" +
                            "Take your time. What matters is that you have progress every day/week/month (however little it may be). The fact that you acknowledge that you want to stop smoking is already a thing in itself, so cheers to that.",
                    "Seeing a psychologist crossed my mind but for an entirely different reason. But my dependence on cigarettes may or may not be correlated to the other issue. I'll definitely consider it.\n" +
                            "\n" +
                            "It's hard not to beat myself up for every failure (quitting cigarettes and life in general) but yes, small steps and small victories matter. Thank you!",
                    "Try hitting the gym! It (kinda) worked for me. Hope it works better for you.",
                    "Madali lang naman mag quit bro, ilang beses na nga akong nag qquit eh.",
                    "I started 2001 (1st year high school), stopped cold turkey 2011. Mura pa yosi nung time ko, lahat naka Marlboro golds or black hehe nasa 30 or 40 pesos lang yata. Nag quit ako when I started going to the gym and also realizing the long term negative effects of the vice. The battle is mostly psychologically, it's your mind craving for it.. I try to carry candy/gums with me and pag lunch break, avoid yosi break sessions second hand smoke is worse I heard. Get a hobby, new interests, anything that can keep your mind away from smoking. And sumama ka sa mga tao na hindi nagyoyosi, hahaha yan pinka effective.");
            generatePost(postRepository,
                    commentRepository,
                    savedUsers,
                    "Why did u quit Smoking?",
                    "Filipino  students arent a stranger tk terms such as \"walwal\" and \"vape on\". As a student did/do you have vices? smoking or drinking alcohol? What caused you to do it? And what made you turn your back at it? Did school, peers, family played a role into making you quit? Or did you made the decision yourself for the better? I need information about a story im making about students overcoming their vices.",
                    "I was in the smoking area one day overlooking the highway. The smog from the jeepneys and buses mixing with the smoke from our cigarettes. On the other side of the street are some homeless families sleeping. I realize that here I am, a third world man living in a third world country contributing to the cliché of a third world habit and i wanted none of it anymore. So i quit.",
                    "Ang hirap kasi umakyat sa lrt pag mahina baga.",
                    "Health paranoia made me stop.\n" +
                            "\n" +
                            "10 years na ako quit this past June.",
                    "I want to quit kasi I found out na smoking is one of the causes of my allergies (nagkakaroon ako ng mga rashes + sumisikip sinus ko) but it is really hard to quit.\uD83D\uDE2D For those who successfully quit, advice please.",
                    "Nung HS ako, I try to have a smoke pag may lakwatsa -- fun lang kasi, feeling rebellious ganyan. Di palagi kasi siyempre ayaw natin matrobol. Had a girlfriend in 4th year and she told me to stop. So I did. Pero nung break na kami, 1st year college na ko nun, full steam ahead na sa pagyoyosi! Mura, accessible, pampatanggal stress, a way to connect with people. Tsaka pag wala nang allowance at gutom ako, dinadaan ko na lang sa yosi, keri na yun.\n" +
                            "\n" +
                            "It took years of post-college before I quit, pero dahil students naman target mo for your study eh di ko na ito pahahabain hehe");

        };
    }

    @Transactional
    public static void generatePost(PostRepository postRepository,
                                    CommentRepository commentRepository,
                                    List<User> userList,
                                    String postTitle,
                                    String postBody,
                                    String ... comments){
        Post post = new Post(
                postTitle,
                postBody,
                LocalDateTime.now(),
                new ArrayList<>(),
                userList.get(new Random().nextInt(userList.size()))
        );
        HashSet<Comment> commentSet = new HashSet<>();
        Random rand = new Random();
        for(String comment: comments){
            commentSet.add(
                    new Comment(
                            userList.get(new Random().nextInt(userList.size())),
                            comment,
                            LocalDateTime.of(rand.nextInt(4)+2017,rand.nextInt(12)+1,rand.nextInt(20)+1, rand.nextInt(12),rand.nextInt(58),rand.nextInt(58))
                    )
            );
        }
        List<Comment> savedComments = commentRepository.saveAll(commentSet);
        post.setComments(savedComments);
        postRepository.save(post);
    }

    public static byte[] getByteArray(String url){
        ClassPathResource backImgFile = new ClassPathResource(url);
        byte[] arrayPic = null;
        try {
            arrayPic = new byte[(int) backImgFile.contentLength()];
            backImgFile.getInputStream().read(arrayPic);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return arrayPic;
    }
}
